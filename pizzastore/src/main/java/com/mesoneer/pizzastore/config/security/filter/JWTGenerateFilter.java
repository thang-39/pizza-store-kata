package com.mesoneer.pizzastore.config.security.filter;

import com.auth0.jwt.JWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Component
public class JWTGenerateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization"); //Bearer JWT
        if(header != null && header.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.nonNull(authentication)) {
            System.out.println(authentication.getAuthorities().stream().toList());
            String token = JWT.create()
                    .withSubject(authentication.getName())
                    .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + 7_200_000)) // expire after 2 hours
                    .sign(HMAC512("w9z$C&E)H@McQfTjWnZr4u7x!A%D*G-JaNdRgUkXp2s5v8y/B?E(H+MbPeShVmYq"));
            response.addHeader("Authorization", "Bearer " + token);
        }
        filterChain.doFilter(request, response);
    }

//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return request.getServletPath().equals("/login");
//    }
}
