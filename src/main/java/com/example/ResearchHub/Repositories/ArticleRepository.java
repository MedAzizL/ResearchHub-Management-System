package com.example.ResearchHub.Repositories;
import com.example.ResearchHub.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByDoi(String doi);
}

