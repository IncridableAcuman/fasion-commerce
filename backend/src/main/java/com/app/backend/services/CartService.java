package com.app.backend.services;

import com.app.backend.entities.Cart;
import com.app.backend.entities.User;
import com.app.backend.exception.NotFoundExceptionHandler;
import com.app.backend.repositories.CartRepository;
import com.app.backend.repositories.ProductRepository;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
}
