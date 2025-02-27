package com.example.ResearchHub.Entities;
import jakarta.persistence.*;
import lombok.*;

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

    // Domain will be added later

    /* @ManyToMany
    @JoinTable(
            name = "article_domaine",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "domaine_id")
    )
    private Set<Domaine> domaines; */
}
