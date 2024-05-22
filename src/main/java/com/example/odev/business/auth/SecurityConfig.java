package com.example.odev.business.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/login", "/api/auth/register", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/api/flights/**").permitAll() // Yeni eklenen servisleri de izinli yap
                        .anyRequest().authenticated()
                )
                .cors(cors -> cors.disable()); // CORS yapılandırmasını etkinleştir

        return http.build();
    }
}
