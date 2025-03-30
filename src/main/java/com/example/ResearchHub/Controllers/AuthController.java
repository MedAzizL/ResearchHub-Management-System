package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return authService.authenticate(email, password);
    }
}
