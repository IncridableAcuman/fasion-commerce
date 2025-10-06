package com.app.backend.dto;

import java.util.List;

public record CartDto(
     String cartId,
     String userId,
     List<CartItemDto> items
) {
}
