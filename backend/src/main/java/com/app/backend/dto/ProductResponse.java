package com.app.backend.dto;

import com.app.backend.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String title;
    private String content;
    private Category category;
    private BigDecimal price;
    private String image;
}
