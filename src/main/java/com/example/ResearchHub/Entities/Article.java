package com.example.ResearchHub.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  // add builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String doi;

    @Column(nullable = false)
    private String titre;

    private String motsCles;


    //added by mazen
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    // Domain will be added later

    /* @ManyToMany
    @JoinTable(
            name = "article_domaine",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "domaine_id")
    )
    private Set<Domaine> domaines; */
}
