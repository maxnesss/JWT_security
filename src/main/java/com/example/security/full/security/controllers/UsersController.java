package com.example.security.full.security.controllers;

import com.example.security.full.security.models.Users;
import com.example.security.full.security.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UsersController {

    private final UsersService usersService;
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("hello")
    public String hello() {
        return "Hello User";
    }


}
