//package com.mesoneer.pizzastore.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//@Configuration
//@EnableWebSecurity
//public class KeyCloakSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth ->
//                        auth.anyRequest().authenticated());
//
//        http
//                .oauth2ResourceServer()
//                .jwt();
//
//
//    }
//}
