package com.app.backend.entities;

import com.app.backend.enums.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String title;
    private String content;
    private Category category;
    private String price;
    private String image;
}
