package com.mesoneer.pizzastore.config.security;

import com.mesoneer.pizzastore.entity.Staff;
import com.mesoneer.pizzastore.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private StaffService staffService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Staff staff = staffService.getUserByUsername(username);
        if (!bCryptPasswordEncoder.matches(password, staff.getPassword())) {
            throw new BadCredentialsException("wrong password");
        }
        return new UsernamePasswordAuthenticationToken(
                username, password,
                this.getGrantedAuthorities(List.of(staff.getRole())));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> authorityEntities) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorityEntities.forEach(a -> authorities.add(new SimpleGrantedAuthority(a)));
        return authorities;
    }
}
