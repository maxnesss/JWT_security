package com.example.security.full.security.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "roles", nullable = false)
    private String Roles;
    private String password;


}
