package com.example.ResearchHub.Dto;

import com.example.ResearchHub.Entities.Contribution;
import com.example.ResearchHub.Enum.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserAuthDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date employmentDate;
    private String originalEstablishment;
    private String lastDiploma;
    private String grade;
    private Role role;
}
