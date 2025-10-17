package com.app.backend.controllers;

import com.app.backend.entities.Cart;
import com.app.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartForUser(@PathVariable String userId){
        return ResponseEntity.ok(cartService.getCartForUser(userId));
    }
    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestParam String userId,
                                           @RequestParam String productId,
                                           @RequestParam int quantity){
        return ResponseEntity.ok(cartService.addToCart(userId,productId,quantity));
    }
    @DeleteMapping
    public ResponseEntity<Cart> removeCart(@RequestParam String userId,@RequestParam String productId){
        return ResponseEntity.ok(cartService.removeCart(userId,productId));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCart(@RequestParam String userId){
        cartService.deleteCart(userId);
        return ResponseEntity.ok("Cart deleted successfully");
    }
}
