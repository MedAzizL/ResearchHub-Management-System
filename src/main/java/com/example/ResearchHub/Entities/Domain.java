package com.example.ResearchHub.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
        import lombok.*;

        import java.util.List;

@Entity
@Table(name = "domains")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomDomaine;

    //@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Article> articles;

}
