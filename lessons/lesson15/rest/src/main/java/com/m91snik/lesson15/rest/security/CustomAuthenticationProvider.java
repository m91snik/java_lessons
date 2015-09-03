package com.m91snik.lesson15.rest.security;

import com.m91snik.lesson15.rest.util.PasswordUtils;
import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        password = PasswordUtils.getPasswordHash(password, name);

        if (!StringUtils.hasText(name) || !StringUtils.hasText(password)) {
            throw new BadCredentialsException("Username/password is empty");
        }

        User user = userService.findByNameAndPassword(name, password);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserType().toString()));
            return new UsernamePasswordAuthenticationToken(
                    user.getId(), authentication.getCredentials(),
                    authorities);
        }
        throw new BadCredentialsException("Username/password is empty");
    }

    @Override
    public boolean supports(Class aClass) {
        return (aClass.equals(UsernamePasswordAuthenticationToken.class));
    }

}
