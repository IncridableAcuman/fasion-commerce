package com.app.backend.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CookieUtil {
    @Value("${jwt.refresh_time}")
    private int refreshTime;
    public void addCookie(String refreshToken, HttpServletResponse response){
        Cookie cookie=new Cookie("refreshToken",refreshToken);
        cookie.setSecure(false);
        cookie.setMaxAge(refreshTime/1000);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
    public void clearCookie(HttpServletResponse response){
        Cookie cookie=new Cookie("refreshToken",null);
        cookie.setSecure(false);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}
