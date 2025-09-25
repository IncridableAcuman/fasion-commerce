package com.app.backend.repositories;

import com.app.backend.entities.Product;
import com.app.backend.enums.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByCategory(Category category);
}
