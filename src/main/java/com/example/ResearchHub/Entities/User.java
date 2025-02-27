package com.example.ResearchHub.Entities;

import com.example.ResearchHub.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
