//package com.mesoneer.pizzastore.config.security.filter;
//
//import com.auth0.jwt.JWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mesoneer.pizzastore.config.security.manager.CustomAuthenticationManager;
//import com.mesoneer.pizzastore.entity.Staff;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
//@Component
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final CustomAuthenticationManager authenticationManager;
//    @Autowired
//
//    public AuthenticationFilter(CustomAuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) {
//        try {
//            Staff staff = new ObjectMapper().readValue(request.getInputStream(), Staff.class);
//            Authentication authentication = new UsernamePasswordAuthenticationToken(
//                    staff.getUsername(),
//                    staff.getPassword()
//            );
//            return authenticationManager.authenticate(authentication);
//
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        String token = JWT.create()
//                .withSubject(authResult.getName())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 7200000)) // expire after 2 hours
//                .sign(HMAC512("w9z$C&E)H@McQfTjWnZr4u7x!A%D*G-JaNdRgUkXp2s5v8y/B?E(H+MbPeShVmYq"));
//        response.addHeader("Authorization", "Bearer " + token);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request,
//                                              HttpServletResponse response,
//                                              AuthenticationException failed) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.getWriter().write(failed.getMessage());    // <--
//        response.getWriter().flush();
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> authorityEntities) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorityEntities.forEach(a -> authorities.add(new SimpleGrantedAuthority(a)));
//        return authorities;
//    }
//}
