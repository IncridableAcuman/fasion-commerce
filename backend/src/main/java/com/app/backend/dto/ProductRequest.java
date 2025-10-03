package com.app.backend.dto;

import com.app.backend.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = "Title must be required")
    @Size(min = 10,max = 50,message = "Title must between 10 and 50 character")
    private String title;

    @NotBlank(message = "Content must be required")
    @Size(min = 20,max = 350,message = "Content must between 20 and 350 character")
    private String content;

    @NotNull(message = "Category must be required")
    private Category category;

    @NotNull(message = "Price must be required")
    private Double price;

    private String image;
}
