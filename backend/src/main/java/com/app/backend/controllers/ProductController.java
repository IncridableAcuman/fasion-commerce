package com.app.backend.controllers;

import com.app.backend.dto.ProductRequest;
import com.app.backend.dto.ProductResponse;
import com.app.backend.enums.Category;
import com.app.backend.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> create(@Valid @ModelAttribute ProductRequest request) throws IOException {
        try {
            return ResponseEntity.ok(productService.create(request));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
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
    public ResponseEntity<String> updateProduct(@PathVariable String id,@Valid @ModelAttribute ProductRequest request) throws IOException{
        return ResponseEntity.ok(productService.updateProduct(id,request));
    }
}
