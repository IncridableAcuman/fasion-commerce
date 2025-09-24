package com.app.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPassword {
    @NotBlank(message = "Token must be required")
    private String token;

    @NotBlank(message = "Password must be required")
    @Size(min = 8,max = 1024,message = "Email must between 3 and 1024 character!")
    private String password;
}
