package com.app.backend.utils;

import com.app.backend.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.access_time}")
    private int accessTime;
    @Value("${jwt.refresh_time}")
    private int refreshTime;

    public SecretKey getSigningKey(){
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
                .expiration(new Date(System.currentTimeMillis()+(expirationTime* 1000L)))
                .compact();
    }
    public String generateAccessToken(User user){
        return generateToken(user,accessTime);
    }
    public String generateRefreshToken(User user){
        return generateToken(user,refreshTime);
    }
    public Claims extractClaim(String token){
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String extractSubject(String token){
        return extractClaim(token).getSubject();
    }
    public Date extractExpiration(String token){
        return extractClaim(token).getExpiration();
    }
    public boolean validateToken(String token){
        if(token==null || token.trim().isEmpty()){
            throw new RuntimeException("Token not found");
        }
        try {
            return extractExpiration(token).after(new Date());
        } catch (RuntimeException e) {
            return false;
        }
    }
}
