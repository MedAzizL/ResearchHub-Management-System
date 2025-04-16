package com.example.ResearchHub.security;

import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("email not found"));

        String roleName = "ROLE_" + user.getRole().name();
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(roleName));
        return  new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), authorities);
    }

}
