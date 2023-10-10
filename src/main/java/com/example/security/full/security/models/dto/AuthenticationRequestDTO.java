package com.example.security.full.security.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
