package com.example.ResearchHub.Repositories;
import com.example.ResearchHub.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByDoi(String doi);

    @Query("SELECT a FROM Article a WHERE LOWER(a.motsCles) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Article> findByMotsClesContaining(@Param("keyword") String keyword);
}

