package com.app.backend.repositories;

import com.app.backend.entities.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem,String> {
}
