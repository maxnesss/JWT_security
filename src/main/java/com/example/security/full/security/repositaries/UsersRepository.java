package com.example.security.full.security.repositaries;

import com.example.security.full.security.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
