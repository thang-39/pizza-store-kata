package com.mesoneer.pizzastore.config.security;

//import com.mesoneer.pizzastore.config.security.filter.AuthenticationFilter;
//import com.mesoneer.pizzastore.config.security.filter.ExceptionalHandlerFilter;
//import com.mesoneer.pizzastore.config.security.filter.JWTAuthorizationFilter;
//import com.mesoneer.pizzastore.config.security.filter.ExceptionalHandlerFilter;
import com.mesoneer.pizzastore.config.security.filter.JWTGenerateFilter;
import com.mesoneer.pizzastore.config.security.filter.JWTValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity()
public class SecurityConfig {

    private final JWTValidator jwtValidator;
    private final JWTGenerateFilter jwtGenerateFilter;

    @Autowired
    public SecurityConfig(JWTValidator jwtValidator, JWTGenerateFilter jwtGenerateFilter) {
        this.jwtValidator = jwtValidator;
        this.jwtGenerateFilter = jwtGenerateFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/products/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/staff").permitAll()
                        .requestMatchers("/product-list/**").permitAll()
                        .requestMatchers("/orders/**").permitAll()
                                .anyRequest().authenticated()

                )
                .addFilterBefore(jwtValidator, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtGenerateFilter, BasicAuthenticationFilter.class)
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }


}
