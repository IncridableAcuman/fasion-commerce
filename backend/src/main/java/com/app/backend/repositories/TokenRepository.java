package com.app.backend.repositories;

import com.app.backend.entities.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token,String> {
    Optional<Token> findByUserId(String userId);
    Optional<Token> findByRefreshToken(String refreshToken);
}
