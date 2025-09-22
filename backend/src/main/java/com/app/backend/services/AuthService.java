package com.app.backend.services;

import com.app.backend.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final TokenService tokenService;
}
