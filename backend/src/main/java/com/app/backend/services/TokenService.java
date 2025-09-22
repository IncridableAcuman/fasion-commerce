package com.app.backend.services;

import com.app.backend.entities.Token;
import com.app.backend.entities.User;
import com.app.backend.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public void createToken(User user,String refreshToken){
        Token token=new Token();
        token.setUserId(user.getId());
        token.setRefreshToken(refreshToken);
        token.setExpiryDate(LocalDateTime.now());
        tokenRepository.save(token);
    }
}
