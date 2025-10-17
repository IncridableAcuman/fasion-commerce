package com.app.backend.services;

import com.app.backend.entities.Cart;
import com.app.backend.entities.CartItem;
import com.app.backend.entities.Product;
import com.app.backend.entities.User;
import com.app.backend.exception.NotFoundExceptionHandler;
import com.app.backend.repositories.CartRepository;
import com.app.backend.repositories.ProductRepository;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Transactional
    public Cart getCartForUser(String userId){
        return cartRepository.findByUserId(userId).orElseGet(()->{
            User user=userRepository.findById(userId).orElseThrow(()->new NotFoundExceptionHandler("User not found"));
            Cart cart=new Cart();
            cart.setUserId(user.getId());
            cart.setItems(new ArrayList<>());
            cart.setTotalPrice(0.0);
            return cartRepository.save(cart);
        });
    }
    @Transactional
    public Cart addToCart(String userId,String productId,int quantity){
        Cart cart=getCartForUser(userId);
        Product product=productRepository.findById(productId).orElseThrow(()->new NotFoundExceptionHandler("Product not found"));
        Optional<CartItem> items=cart.getItems().stream()
                .filter(item->item.getProductId().equals(productId)).findFirst();
        if (items.isPresent()){
            items.get().setQuantity(items.get().getQuantity()+quantity);
        } else {
            CartItem item=new CartItem();
            item.setQuantity(quantity);
            item.setProductName(product.getTitle());
            item.setProductImage(product.getImage());
            item.setProductId(product.getId());
            item.setProductPrice(product.getPrice());
            cart.getItems().add(item);
        }
        double total=cart.getItems().stream()
                .mapToDouble(it->it.getProductPrice()*it.getQuantity()).sum();
        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }
    @Transactional
    public Cart removeCart(String userId,String productId){
        Cart cart=getCartForUser(userId);
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        double total=cart.getItems().stream().mapToDouble(it->it.getProductPrice()*it.getQuantity()).sum();
        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }
    @Transactional
    public void deleteCart(String userId){
        Cart cart=getCartForUser(userId);
        cart.setItems(new ArrayList<>());
        cart.setTotalPrice(0.0);
    }
}
