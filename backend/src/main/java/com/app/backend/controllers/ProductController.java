package com.app.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.backend.dto.ProductRequest;
import com.app.backend.dto.ProductResponse;
import com.app.backend.enums.Category;
import com.app.backend.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
            return ResponseEntity.ok(productService.create(request));  
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(){
           return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse> > getProductsByCategory(@PathVariable Category category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id,@Valid @RequestBody ProductRequest request)  {
        return ResponseEntity.ok(productService.updateProduct(id,request));
    }
}
