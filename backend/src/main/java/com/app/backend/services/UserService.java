package com.app.backend.services;

import com.app.backend.dto.RegisterRequest;
import com.app.backend.entities.User;
import com.app.backend.enums.Role;
import com.app.backend.exception.BadRequestExceptionHandler;
import com.app.backend.exception.NotFoundExceptionHandler;
import com.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(RegisterRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new BadRequestExceptionHandler("User already exist");
        }
        User user=new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
    @Transactional
    public User findUser(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new NotFoundExceptionHandler("User not found"));
    }
    public void validatePassword(String rawPassword,String userPassword){
        if(!passwordEncoder.matches(rawPassword,userPassword)){
            throw new BadRequestExceptionHandler("Password is mismatch");
        }
    }
}
