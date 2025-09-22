package com.app.backend.utils;

import com.app.backend.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.access_time}")
    private int accessTime;
    @Value("${jwt.refresh_time}")
    private int refreshTime;

    public Key getSigningKey(){
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(User user,int expirationTime){
       return Jwts
                .builder()
                .subject(user.getEmail())
                .claim("id",user.getId())
                .claim("username",user.getUsername())
                .claim("role",user.getRole())
               .signWith(getSigningKey())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+expirationTime))
                .compact();
    }
    public String generateAccessToken(User user){
        return generateToken(user,accessTime);
    }
    public String generateRefreshToken(User user){
        return generateToken(user,refreshTime);
    }

}
