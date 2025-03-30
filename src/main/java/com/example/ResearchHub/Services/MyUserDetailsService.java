package com.example.ResearchHub.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you should fetch the user from the database
        if ("admin".equals(username)) {
            return new User("admin", "$2a$10$7QH9r0Fqg2fQ8eI7lAIkdOz.rOht7ch6Rn/jC5m08PoX/OHiHkW3m", new ArrayList<>()); // password: admin (hashed)
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
