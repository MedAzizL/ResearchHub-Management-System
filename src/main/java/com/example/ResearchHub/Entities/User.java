package com.example.ResearchHub.Entities;

import com.example.ResearchHub.Enum.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Contribution> contributions;
    // In User entity
  //  @ManyToMany(mappedBy = "authors")
  //  private List<Article> authoredArticles;
}
