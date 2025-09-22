package com.app.backend.services;

import com.app.backend.dto.RegisterRequest;
import com.app.backend.entities.User;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User createUser(RegisterRequest request){
        
    }
}
