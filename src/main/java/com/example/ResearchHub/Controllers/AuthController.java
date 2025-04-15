package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Dto.AuthResponseDTO;
import com.example.ResearchHub.Dto.LoginDto;
import com.example.ResearchHub.Dto.UserAuthDTO;
import com.example.ResearchHub.Dto.UserCreateRequest;
import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Services.UserService;
import com.example.ResearchHub.security.CustomUserDetailsService;
import com.example.ResearchHub.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtGenerator;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        Optional<User> optionalUser = userService.getUserByemail(loginDto.getEmail());
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()));
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Mot de passe incorrect");
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getEmail());

        String jwt = jwtGenerator.generateToken(userDetails.getUsername());
        User user = optionalUser.get();

        UserAuthDTO userDTO = UserAuthDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .employmentDate(user.getEmploymentDate())
                .originalEstablishment(user.getOriginalEstablishment())
                .lastDiploma(user.getLastDiploma())
                .grade(user.getGrade())
                .role(user.getRole())
                .build();

        return ResponseEntity.ok(new AuthResponseDTO(jwt, userDTO));

    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);
    }
}
