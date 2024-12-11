package com.example.OnlineAssignmentSystem.repository;

import com.example.OnlineAssignmentSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username for login
    Optional<User> findByUsername(String username);
}
