package com.example.security.full.security.controllers;

import com.example.security.full.security.models.Users;
import com.example.security.full.security.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UsersService usersService;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello Admin");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("users")
    public List<Users> GetUsers() {
        return usersService.GetAllUsers();
    }

}
