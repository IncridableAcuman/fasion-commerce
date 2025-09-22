package com.app.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tokens")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    private String id;

    private String refreshToken;

    private String userId;

    private LocalDateTime expiryDate;
}
