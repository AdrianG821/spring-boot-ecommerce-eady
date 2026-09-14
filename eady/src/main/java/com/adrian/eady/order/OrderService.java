package com.adrian.eady.order;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

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

    public OrderService(OrderRepository db, UserRepository userDb, CartRepository cartDb, OrderItemRepository itemDb) { this.db = db;  this.userDb = userDb; this.cartDb = cartDb; this.itemDb = itemDb;}
    
    public List<OrderResponseDTO> getAllOrders(Long userId) {

        User user = userDb.findById(userId).orElse(null);

        if(user == null) {
            return null;
        }

        List<Order> orders = db.findByUserId(userId);

        List<OrderResponseDTO> response = orders.stream().map(order -> mapToResponseDTO(order)).toList();

        return response;

    }



    public Integer createOrder(OrderCreateDTO create){
        if(create == null) return null;

        User user = userDb.findById(create.getUserId()).orElse(null);
        if(user == null) return null;

        List<Cart> carts = cartDb.findByUserId(user.getId());

        Order order = null;
        String paymentForm = create.getPaymentForm();
        String address = create.getAddress();
        Boolean active = true;

        
        List<Long> productIds = carts.stream().map(cart -> cart.getProduct().getId()).toList();

        if(productIds.isEmpty()) return null;

        
        Double totalPrice = getTotalPrice(carts);


        order = new Order(paymentForm, address, totalPrice, user, active);

        db.save(order);

        for(int i = 0; i < productIds.size(); i++){
            if(order == null) return null;

            Cart actualCart = carts.get(i);

            if(actualCart == null) return null;

            OrderItem item = new OrderItem(order ,actualCart.getProduct().getPrice(),actualCart.getProduct(), actualCart.getQuantity());

            if(item == null) return null;

            itemDb.save(item);
        }

        return Integer.valueOf(order.getId().intValue());


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
}
