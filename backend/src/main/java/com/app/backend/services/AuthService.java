package com.app.backend.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.backend.dto.AuthRequest;
import com.app.backend.dto.AuthResponse;
import com.app.backend.dto.RegisterRequest;
import com.app.backend.entities.User;
import com.app.backend.exception.BadRequestExceptionHandler;
import com.app.backend.utils.CookieUtil;
import com.app.backend.utils.JWTUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final TokenService tokenService;
    private final CookieUtil cookieUtil;

    public AuthResponse authResponse(User user,String accessToken,String refreshToken){
        return new AuthResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), accessToken, refreshToken);}

    @Transactional
    public AuthResponse register(RegisterRequest request, HttpServletResponse response){
        User user=userService.createUser(request);
        String accessToken= jwtUtil.generateAccessToken(user);
        String refreshToken= jwtUtil.generateRefreshToken(user);
        tokenService.createToken(user,refreshToken);
        cookieUtil.addCookie(refreshToken,response);
        return authResponse(user,accessToken,refreshToken);
    }

    @Transactional
    public AuthResponse login(AuthRequest request,HttpServletResponse response){
        User user=userService.findUser(request.getEmail());
        userService.validatePassword(request.getPassword(), user.getPassword());
        String accessToken= jwtUtil.generateAccessToken(user);
        String refreshToken= jwtUtil.generateRefreshToken(user);
        tokenService.authToken(user,refreshToken);
        cookieUtil.addCookie(refreshToken,response);
        return authResponse(user,accessToken,refreshToken);
    }

    @Transactional
    public AuthResponse refresh(String refreshToken,HttpServletResponse response){
        tokenService.validateToken(refreshToken);
        if(!jwtUtil.validateToken(refreshToken)){
            throw new BadRequestExceptionHandler("Invalid token");
        }
        String email= jwtUtil.extractSubject(refreshToken);
        User user=userService.findUser(email);
        String newAccessToken= jwtUtil.generateAccessToken(user);
        String newRefreshToken= jwtUtil.generateRefreshToken(user);
        tokenService.authToken(user,newRefreshToken);
        cookieUtil.addCookie(newRefreshToken,response);
        return authResponse(user,newAccessToken,newRefreshToken);
    }
}
