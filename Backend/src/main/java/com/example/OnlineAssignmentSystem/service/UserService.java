package com.example.OnlineAssignmentSystem.service;

import com.example.OnlineAssignmentSystem.model.User;
import com.example.OnlineAssignmentSystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from repository by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Map roles to authorities (with ROLE_ prefix)
        Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))  // Adding ROLE_ prefix for Spring Security roles
                .collect(Collectors.toList());

        // Return the user object with the roles (authorities)
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    // Save method to register users, encode passwords, etc.
    public User saveUser(User user) {
        // Password encoding should be done before saving the user (handled in the controller)
        return userRepository.save(user);
    }
}
