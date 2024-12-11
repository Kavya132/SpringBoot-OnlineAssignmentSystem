package com.example.OnlineAssignmentSystem.config;

import com.example.OnlineAssignmentSystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    // Injecting UserService as UserDetailsService
    public SecurityConfig(UserDetailsService userService) {
        this.userService = (UserService) userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder bean for bcrypt
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);  // Use UserService as the UserDetailsService
        provider.setPasswordEncoder(passwordEncoder());  // Set password encoder
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/users/signup", "/api/users/login").permitAll() // Public paths for login/signup
                .requestMatchers("/api/assignments/create", "/api/grades/assign", "/api/feedbacks/give").hasRole("FACULTY") // Faculty actions
                .requestMatchers("/api/submissions/submit", "/api/feedbacks/view").hasRole("STUDENT") // Student actions
                .anyRequest().authenticated() // Any other request must be authenticated
            .and()
            .formLogin().permitAll(); // Enable form login (optional if you want a login page)

        return http.build();  // Return the configured HttpSecurity
    }
}
