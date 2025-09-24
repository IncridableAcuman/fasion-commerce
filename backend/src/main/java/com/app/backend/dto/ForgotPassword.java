package com.app.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForgotPassword {
    @NotBlank(message = "Email must be required")
    @Email
    private String email;
}
