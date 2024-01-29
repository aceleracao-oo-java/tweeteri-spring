package com.tweetero.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tweetero.api.DTO.UserDTO;
import com.tweetero.api.models.User;
import com.tweetero.api.repositories.AuthRepository;

@Service
public class AuthService {
    @Autowired
    private AuthRepository repository;

    public void signUp(UserDTO data) {
        repository.save(new User(data));
    }
}
