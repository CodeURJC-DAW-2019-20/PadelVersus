package com.example.padelversus.user;

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
import java.util.Optional;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserComponent userComponent;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        Optional<User> optionalUser = userRepository.findByName(auth.getName()); //User from BBDD

        if (!optionalUser.isPresent()) {
            throw new BadCredentialsException("User not found");
        }

        String password = (String) auth.getCredentials();
        if (!new BCryptPasswordEncoder().matches(password, optionalUser.get().getPasswordHash())) {
            throw new BadCredentialsException("Wrong password");
        }
        User user = optionalUser.get();
        userComponent.setLoggedUser(user);

        List<GrantedAuthority> roles = new ArrayList<>();
        for (String role : optionalUser.get().getRoles()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        userComponent.setLoggedUser(user);

        return new UsernamePasswordAuthenticationToken(optionalUser.get().getName(), password, roles); //If user exists and pass is correct we create an objetct with the roles
    }

    @Override
    public boolean supports(Class<?> authenticationObject) {
        return true;
    }
}
