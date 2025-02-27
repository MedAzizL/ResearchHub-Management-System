package com.example.ResearchHub.Dto;

import com.example.ResearchHub.Enum.Role;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date employmentDate;
    private String originalEstablishment;
    private String lastDiploma;
    private String grade;
    private Role role;
}
