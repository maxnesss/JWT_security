package com.example.security.full.security.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
}
