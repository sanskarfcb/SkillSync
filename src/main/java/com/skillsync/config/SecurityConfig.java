package com.skillsync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // ✅ Disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // ✅ Allow all requests
                );
        return http.build();  // ✅ Build the security filter chain
    }
}
