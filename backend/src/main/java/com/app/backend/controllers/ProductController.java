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

    @PostMapping("/product/create")
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) throws IOException {
        return ResponseEntity.ok(productService.create(request));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductResponse> > getProductsByCategory(@PathVariable Category category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id,@Valid @RequestBody ProductRequest request) throws IOException{
        return ResponseEntity.ok(productService.updateProduct(id,request));
    }
}
