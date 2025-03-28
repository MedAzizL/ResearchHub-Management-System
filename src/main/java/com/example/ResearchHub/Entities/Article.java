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

    @Column(nullable = false)
    private String motsCles;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    @ManyToOne
    @JoinColumn(name="domaine_id",nullable = false)
    private Domain domain;

    @ManyToMany
    @JoinTable(
            name = "article_authors",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> authors;


//recherche by doi
 //affecter un article a un utilisateur
}
