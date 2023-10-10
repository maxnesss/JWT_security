package com.example.security.full.security.services;

import com.example.security.full.security.models.Users;
import com.example.security.full.security.repositaries.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> GetAllUsers() {
        return usersRepository.findAll();
    }
    public boolean userExists(String email) {
        return usersRepository.findByEmail(email).isPresent();
    }


}
