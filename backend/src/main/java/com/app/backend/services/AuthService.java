package com.app.backend.services;

import com.app.backend.dto.AuthRequest;
import com.app.backend.dto.AuthResponse;
import com.app.backend.dto.RegisterRequest;
import com.app.backend.entities.Token;
import com.app.backend.entities.User;
import com.app.backend.utils.CookieUtil;
import com.app.backend.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
