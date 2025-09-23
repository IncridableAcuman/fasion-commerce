package com.app.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String id;
    private String username;
    private String email;
    private String role;
    private String accessToken;
    private String refreshToken;
}
