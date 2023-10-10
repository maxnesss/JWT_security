package com.example.security.full.security.security.controller;

import com.example.security.full.security.security.UserSecurity.dao.JpaUserDetailsService;
import com.example.security.full.security.security.UserSecurity.model.UserSecurity;
import com.example.security.full.security.models.dto.AuthenticationRequestDTO;
import com.example.security.full.security.security.service.AuthService;
import com.example.security.full.security.security.config.Constants;
import com.example.security.full.security.security.config.JwtUtils;
import com.example.security.full.security.models.dto.RegisterUserDTO;
import com.example.security.full.security.services.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JpaUserDetailsService jpaUserDetailsService;

    private final AuthService authService;

    private final JwtUtils jwtUtils;
    private final UsersService usersService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequestDTO request, HttpServletResponse response) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getEmail());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                Cookie cookie = new Cookie("jwt", jwt);
                cookie.setMaxAge((int) (Constants.EXPIRATION_TIME/1000)); // expires in 10 days
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
                return ResponseEntity.ok(jwt);
            }
            return ResponseEntity.status(400).body("Error authenticating");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO user) throws Exception {
        if (usersService.userExists(user.getEmail())) {
            return ResponseEntity.status(400).body("User with this email already exists");
        }
        authService.AddUser(user).map(UserSecurity::new).orElseThrow(() -> new Exception("Unknown"));
        return ResponseEntity.ok("User registered successfully");
    }

}
