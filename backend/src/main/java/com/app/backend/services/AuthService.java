package com.app.backend.services;

import com.app.backend.dto.*;
import com.app.backend.enums.Role;
import com.app.backend.exception.ServerErrorExceptionHandler;
import com.app.backend.utils.MailUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final MailUtil mailUtil;

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
        if(refreshToken==null){throw new BadRequestExceptionHandler("Token is required or expired");}
        if(!jwtUtil.validateToken(refreshToken)){throw new BadRequestExceptionHandler("Invalid token");}
        String email= jwtUtil.extractSubject(refreshToken);
        User user=userService.findUser(email);
        String newAccessToken= jwtUtil.generateAccessToken(user);
        String newRefreshToken= jwtUtil.generateRefreshToken(user);
        tokenService.authToken(user,newRefreshToken);
        cookieUtil.addCookie(newRefreshToken,response);
        return authResponse(user,newAccessToken,newRefreshToken);
    }

    @Transactional
    public void logout(String refreshToken,HttpServletResponse response){
        if(refreshToken==null || !jwtUtil.validateToken(refreshToken)){throw new BadRequestExceptionHandler("Token is invalid or expired.");}
        String email= jwtUtil.extractSubject(refreshToken);
        User user=userService.findUser(email);
        tokenService.deleteToken(user);
        cookieUtil.clearCookie(response);
    }

    @Transactional
    public String forgotPassword(ForgotPassword forgotPassword){
        User user=userService.findUser(forgotPassword.getEmail());
        String token= jwtUtil.generateAccessToken(user);
        String url="http://localhost:5173/reset-password?token="+token;
        mailUtil.sendMail(user.getEmail(), "Reset Password",url);
        return "Reset password link sent to email.";
    }

    @Transactional
    public String updatePassword(ResetPassword resetPassword){
        if(!jwtUtil.validateToken(resetPassword.getToken())){
            throw new BadRequestExceptionHandler("Token is invalid or expired.");
        }
        String email= jwtUtil.extractSubject(resetPassword.getToken());
        User user=userService.findUser(email);
        userService.updatePassword(user, resetPassword.getPassword());
        return "Password has updated successfully";
    }
    public AuthUser response(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Object principal=authentication.getPrincipal();
        if(principal instanceof User user){
            return new AuthUser(user.getId(),user.getUsername(),user.getRole());
        }
        throw new ServerErrorExceptionHandler("Internal Server Error");
    }
    @Transactional
    public void updateRole(String id){
        User user=userService.findUserById(id);
        if (user.getRole()!=null){
            user.setRole(Role.ADMIN);
        }
    }
}
