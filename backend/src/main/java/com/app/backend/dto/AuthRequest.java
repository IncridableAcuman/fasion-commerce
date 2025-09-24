package com.app.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "Email must be required")
    @Email
    private String email;
    @NotBlank(message = "Password must be required")
    @Size(min = 8,max = 1024,message = "Password must between 3 and 1024 character!")
    private String password;
}
