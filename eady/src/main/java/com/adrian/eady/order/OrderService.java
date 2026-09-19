package com.adrian.eady.order;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.eady.cart.Cart;
import com.adrian.eady.cart.CartRepository;
import com.adrian.eady.order.dto.OrderCreateDTO;
import com.adrian.eady.order.dto.OrderResponseDTO;
import com.adrian.eady.product.Product;
import com.adrian.eady.product.ProductRepository;
import com.adrian.eady.user.User;
import com.adrian.eady.user.UserRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class OrderService {

    private final OrderRepository db;
    private final UserRepository  userDb;
    private final CartRepository  cartDb;
    private final OrderItemRepository itemDb;
    private final ProductRepository prodDb;

    public OrderService(OrderRepository db, UserRepository userDb, CartRepository cartDb, OrderItemRepository itemDb, ProductRepository prodDb) { this.db = db;  this.userDb = userDb; this.cartDb = cartDb; this.itemDb = itemDb; this.prodDb = prodDb;}
    
    public List<OrderResponseDTO> getAllOrders(Long userId) {

        User user = userDb.findById(userId).orElse(null);

        if(user == null) {
            return null;
        }

        List<Order> orders = db.findByUserId(userId);

        List<OrderResponseDTO> response = orders.stream().map(order -> mapToResponseDTO(order)).toList();

        return response;

    }


    @Transactional 
    public Long createOrder(OrderCreateDTO create){
        if(create == null) throw new RuntimeException("The order is empty!");

        User user = userDb.findById(create.getUserId()).orElse(null);
        
        if(user == null) throw new RuntimeException("The user dosent exists!");

        List<Cart> carts = cartDb.findByUserId(user.getId());
        
        if(carts.isEmpty()) throw new RuntimeException("The cart is empty!");

        List<Long> productsIds = carts.stream().map( item -> item.getProduct().getId() ).toList();

        List<Product> products = prodDb.findAllById(productsIds);
        
        if(!isEnoughStock(carts,products)) throw new RuntimeException("The stock is not enough!");

        Order order = null;
        String paymentForm = create.getPaymentForm();
        String address = create.getAddress();
        Boolean active = true;

        
        Double totalPrice = getTotalPrice(carts);


        order = new Order(paymentForm, address, totalPrice, user, active);

        db.save(order);


        for(int i = 0; i < carts.size(); i++){
            Cart actualCart = carts.get(i);

            OrderItem item = new OrderItem(order ,actualCart.getProduct().getPrice(),actualCart.getProduct(), actualCart.getQuantity());

            Product tempProd = products.stream().filter(product -> product.getId().equals(actualCart.getProduct().getId())).findFirst().orElse(null);

            if(tempProd == null) throw new RuntimeException("Internal server error!");

            tempProd.setStock(tempProd.getStock() - actualCart.getQuantity());
            prodDb.save(tempProd);


            itemDb.save(item);
        }

        cartDb.deleteAll(carts);
        return order.getId();
    }

    public String cancelOrder(Long id) {
        Order order = db.findById(id).orElse(null);

        if(order == null) return null;

        order.setActive(false);
        db.save(order);

        return "Order cancelled!";
        
    }

    private OrderResponseDTO mapToResponseDTO(Order order){
        if(order == null){
            return null;
        } else if(order.getUser() == null) {
            return null;
        }

        User user = order.getUser();

        return new OrderResponseDTO(order.getId(), order.getPaymentForm(), order.getAddress(), order.getTotalPrice(), order.getActive(),order.getCreatedAt());

    }

    private Double getTotalPrice(List<Cart> carts){
        Double totalPrice = 0.00;

        List<Double> prices = carts.stream().map(cart -> cart.getProduct().getPrice()).toList();

        for(int i = 0; i < prices.size();i++){
            totalPrice += prices.get(i) * carts.get(i).getQuantity();
        }

        return totalPrice;
    }

    private boolean isEnoughStock(List<Cart> itemsList, List<Product> prod){
        List<Product> products = prod;

        for(int i = 0; i < itemsList.size(); i++){
            Cart tempCart = itemsList.get(i);
            Product tempProd = products.stream().filter(product -> product.getId().equals(tempCart.getProduct().getId())).findFirst().orElse(null);

            if(tempProd == null) return false;

            if(tempCart.getQuantity() > tempProd.getStock()){
                return false;
            }

        }

        return true;
    }
}
