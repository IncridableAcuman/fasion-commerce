package com.app.backend.services;

import com.app.backend.dto.ProductRequest;
import com.app.backend.dto.ProductResponse;
import com.app.backend.entities.Product;
import com.app.backend.enums.Category;
import com.app.backend.exception.BadRequestExceptionHandler;
import com.app.backend.exception.NotFoundExceptionHandler;
import com.app.backend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Value("${file.upload_dir}")
    private String uploadDirection;

    public String saveFile(MultipartFile file){
        try{
            String file_name=System.currentTimeMillis()+file.getOriginalFilename();
            Path file_path= Paths.get(uploadDirection,file_name);
            Files.write(file_path,file.getBytes());
            return "/uploads/"+file_name;
        } catch (Exception e) {
            throw new BadRequestExceptionHandler(e.getMessage());
        }
    }

    public ProductResponse productResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getTitle(),
                product.getContent(),
                product.getCategory(),
                product.getPrice(),
                product.getImage()
        );
    }

    @Transactional
    public ProductResponse create (ProductRequest request)   {
        Product product=new Product();
        product.setTitle(request.getTitle());
        product.setContent(request.getContent());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        if(request.getImage()!=null && !request.getImage().isEmpty()){
            String imageUrl=saveFile(request.getImage());
            product.setImage(imageUrl);
        }
        productRepository.save(product);
        return productResponse(product);
    }

    @Transactional
    public List<ProductResponse> getProducts(){
        List<Product> products=productRepository.findAll();
        return products.stream().map(this::productResponse).toList();
    }

    @Transactional
    public List<ProductResponse> getProductsByCategory(Category category){
        List<Product> products=productRepository.findByCategory(category);
        return products.stream().map(this::productResponse).toList();
    }

    @Transactional
    public String deleteProduct(String id){
        Product product=productRepository.findById(id).orElseThrow(()->new NotFoundExceptionHandler("Product not found"));
        productRepository.delete(product);
        return "Product deleted.";
    }

    @Transactional
    public String updateProduct(String id,ProductRequest request)  {
        Product product=productRepository.findById(id).orElseThrow(()->new NotFoundExceptionHandler("Product not found"));
        product.setTitle(request.getTitle());
        product.setContent(request.getContent());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        if(request.getImage()!=null && !request.getImage().isEmpty()){
            String imageUrl=saveFile(request.getImage());
            product.setImage(imageUrl);
        }
        productRepository.save(product);
        return "Updated successfully";
    }
}
