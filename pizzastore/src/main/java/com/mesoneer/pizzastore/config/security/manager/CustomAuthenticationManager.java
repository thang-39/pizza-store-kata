//package com.mesoneer.pizzastore.config.security.manager;
//
//import com.mesoneer.pizzastore.entity.Staff;
//import com.mesoneer.pizzastore.service.StaffService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//
//public class CustomAuthenticationManager implements AuthenticationManager {
//    private final StaffService staffService;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    public CustomAuthenticationManager(StaffService staffService, BCryptPasswordEncoder passwordEncoder) {
//        this.staffService = staffService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        Staff staff = staffService.getUserByUsername(authentication.getName());
//        if (!passwordEncoder.matches(authentication.getCredentials().toString(), staff.getPassword())) {
//            throw new BadCredentialsException("wrong password");
//        }
//        return new UsernamePasswordAuthenticationToken(authentication.getName(), staff.getPassword());
//    }
//}
