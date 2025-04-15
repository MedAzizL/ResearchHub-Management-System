package com.example.ResearchHub.Dto;

import com.example.ResearchHub.Entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class AuthResponseDTO {
    private String accessToken;
    private UserAuthDTO user;//private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken,UserAuthDTO user) {
        this.accessToken = accessToken;
        this.user= user;
    }
}
