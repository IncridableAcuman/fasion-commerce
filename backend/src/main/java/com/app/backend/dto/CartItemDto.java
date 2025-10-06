package com.app.backend.dto;

public record CartItemDto(
         String productId,
         String productName,
         String productImage,
         int quantity,
         Double productPrice
) {
}
