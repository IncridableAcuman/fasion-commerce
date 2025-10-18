package com.app.backend.controllers;

import com.app.backend.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.backend.services.AuthService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request, HttpServletResponse response){
        return ResponseEntity.ok(authService.register(request,response));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request,HttpServletResponse response){
        return ResponseEntity.ok(authService.login(request,response));
    }

    @GetMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@CookieValue(name = "refreshToken",required = false) String refreshToken, HttpServletResponse response){
        return ResponseEntity.ok(authService.refresh(refreshToken,response));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue(name = "refreshToken",required = false) String refreshToken,HttpServletResponse response){
        authService.logout(refreshToken,response);
        return ResponseEntity.ok("Logged out");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPassword forgotPassword){
        return ResponseEntity.ok(authService.forgotPassword(forgotPassword));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPassword resetPassword){
        return ResponseEntity.ok(authService.updatePassword(resetPassword));
    }

    @GetMapping
    public ResponseEntity<AuthUser> authUser(){
        return ResponseEntity.ok(authService.response());
    }

    @PatchMapping("/role/{id}")
    public ResponseEntity<String> updateRole(@PathVariable String id){
        authService.updateRole(id);
        return ResponseEntity.ok("User: "+ id + "Role update successfully");
    }
}
