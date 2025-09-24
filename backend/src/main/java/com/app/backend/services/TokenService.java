package com.app.backend.services;

import com.app.backend.entities.Token;
import com.app.backend.entities.User;
import com.app.backend.exception.BadRequestExceptionHandler;
import com.app.backend.exception.NotFoundExceptionHandler;
import com.app.backend.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${jwt.refresh_time}")
    private int refreshTime;
    private final TokenRepository tokenRepository;

    public void createToken(User user,String refreshToken){
        Token token=new Token();
        token.setUserId(user.getId());
        token.setRefreshToken(refreshToken);
        token.setExpiryDate(LocalDateTime.now().plusSeconds(refreshTime));
        tokenRepository.save(token);
    }
    public void authToken(User user,String refreshToken){
        tokenRepository.findByUserId(user.getId()).ifPresentOrElse(token -> {
            token.setRefreshToken(refreshToken);
            token.setExpiryDate(LocalDateTime.now().plusSeconds(refreshTime));
            tokenRepository.save(token);
        },
                ()->createToken(user,refreshToken)
        );
    }
    public void validateToken(String refreshToken){
        if(refreshToken==null || !refreshToken.startsWith("Bearer ")){
            throw new BadRequestExceptionHandler("Invalid token");
        }
    }
    public void findByRefreshToken(String refreshToken){
        tokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new NotFoundExceptionHandler("Token not found"));
    }
}
