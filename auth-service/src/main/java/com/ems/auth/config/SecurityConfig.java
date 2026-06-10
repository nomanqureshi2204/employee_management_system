package com.ems.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.ems.auth.filter.JwtFilter;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SecurityConfig {

//    @Autowired
//    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // ✅ SWAGGER
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/favicon.ico"
                        ).permitAll()

                        // ✅ PUBLIC APIs
                        .requestMatchers(
                                "/auth/login",
                                "/auth/encode"
                        ).permitAll()

                        // ✅ ADMIN API
                        .requestMatchers("/auth/test")
                        .hasRole("ADMIN")

                        // ✅ ALL OTHER
                        .anyRequest()
                        .authenticated()
                )

                // ✅ JWT FILTER
//                .addFilterBefore(
//                        jwtFilter,
//                        UsernamePasswordAuthenticationFilter.class
//                )

                // ✅ STATELESS
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config)
            throws Exception {

        return config.getAuthenticationManager();
    }

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(
                        new Info()
                                .title("EMS AUTH SERVICE")
                                .version("1.0")
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("Bearer Authentication")
                )

                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "Bearer Authentication",

                                        new SecurityScheme()
                                                .name("Authorization")
                                                .type(
                                                        SecurityScheme.Type.HTTP
                                                )
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}