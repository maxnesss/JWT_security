package com.example.security.full.security.security.service;

import com.example.security.full.security.models.dto.RegisterUserDTO;
import com.example.security.full.security.models.AppUser;
import com.example.security.full.security.repositaries.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UsersRepository usersRepository;

    public Optional<AppUser> AddUser(RegisterUserDTO user) {
        AppUser newUser = new AppUser();
        newUser.setFirst_name(user.getFirst_name());
        newUser.setLast_name(user.getLast_name());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles("ROLE_USER");
        return Optional.of(usersRepository.save(newUser));
    }
}
