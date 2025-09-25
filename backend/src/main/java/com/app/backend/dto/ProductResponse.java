package com.app.backend.dto;

import com.app.backend.enums.Category;
import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String title;
    private String content;
    private Category category;
    private String price;
    private String image;
}
