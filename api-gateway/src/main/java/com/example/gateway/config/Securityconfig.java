package com.example.gateway.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Securityconfig {

    // 🔥 AUTH-SERVICE APIs group
    @Bean
    public GroupedOpenApi authServiceApi() {
        return GroupedOpenApi.builder()
                .group("auth-service")
                .pathsToMatch("/auth/**")
                .build();
    }


    // 👉 Agar aur services add karni ho to bas same pattern follow karna
}