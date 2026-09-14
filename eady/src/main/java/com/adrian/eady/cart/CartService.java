package com.adrian.eady.cart;

import java.util.List;
import java.util.Optional;

import com.adrian.eady.categories.Category;

import org.springframework.stereotype.Service;

import com.adrian.eady.cart.dto.CartCreateDTO;
import com.adrian.eady.cart.dto.CartDeleteDTO;
import com.adrian.eady.cart.dto.CartResponseDTO;
import com.adrian.eady.cart.dto.ProductCartDTO;
import com.adrian.eady.product.Product;
import com.adrian.eady.product.ProductRepository;
import com.adrian.eady.product.dto.ProductResponseDTO;
import com.adrian.eady.user.User;
import com.adrian.eady.user.UserRepository;

@Service
public class CartService {

    private final CartRepository           db;
    private final UserRepository           dbUser;
    private final ProductRepository        dbProduct;

    public CartService(CartRepository db, UserRepository user, ProductRepository product) { 
        this.db         = db; 
        this.dbUser     = user;
        this.dbProduct    = product;
    }

    public List<CartResponseDTO> getCart(Long id) {
        List<Cart> products = db.findByUserId(id);

        List<CartResponseDTO> response = products.stream().map( product -> CartMapToDTO(product) ).toList();

        return response;
    }

 
    public String addCartProduct(CartCreateDTO cart) {
        Long    productId = cart.getProductId();
        Long    userId    = cart.getUserId();
        Integer quantity  = cart.getQuantity();

        if(productId == null || productId == 0 || userId == null || userId == 0 || quantity == null || quantity <= 0){
            return null;
        }
        
        Product product = dbProduct.findById(cart.getProductId()).orElse(null);
        User    user    = dbUser.findById(cart.getUserId()).orElse(null);

        if(product == null || user == null) {
            return null;
        }

        Optional<Cart>              exists  = db.findByUserIdAndProductId(user.getId(), product.getId());

        if(exists.isPresent()) {
            Cart existingCart = exists.get();
            existingCart.setQuantity(existingCart.getQuantity() + quantity);
            db.save(existingCart);
            return "Quantity added";
        }

        Cart newCart = new Cart(user,product, quantity);

        db.save(newCart);

        return "Product added succesfully";
        
    }

    public String removeCartProduct(CartDeleteDTO dto) {
        Long productId = dto.getProductId();
        Long userId    = dto.getUserId();

        if(productId == null || productId == 0 || userId == null || userId == 0){
            return null;
        }



        Product product = dbProduct.findById(productId).orElse(null);
        User    user    = dbUser.findById(userId).orElse(null);

        if(product == null || user == null) {
            return null;
        }

        Optional<Cart>             optionalCart  = db.findByUserIdAndProductId(user.getId(), product.getId());

        Cart exists = optionalCart.orElse(null);

        if(exists == null) {
            return "You dont have this product in your cart";
        }
        
        db.deleteById(exists.getId());

        return "Product removed succesfully!";
    }

    private CartResponseDTO CartMapToDTO(Cart cart) {

        if(cart == null) {
            return null;
        }

        ProductCartDTO product  = ProductMapToDTO(cart.getProduct());
        User           user     = cart.getUser();

        Long           userId   = user.getId();

        return new CartResponseDTO(cart.getId(), userId, product, cart.getQuantity() ,cart.getCreatedAt());

    }

    private ProductCartDTO ProductMapToDTO(Product prod) {
        if(prod == null) {
            return null;
        }

        Category cat = prod.getCategory();


        Long categoryId = null;
        String categoryName = null;

        if(cat != null) {
            categoryId = cat.getId();
            categoryName = cat.getName();
        }

        return new ProductCartDTO(prod.getId(), prod.getName(), prod.getPrice() , categoryName);
    }
}
