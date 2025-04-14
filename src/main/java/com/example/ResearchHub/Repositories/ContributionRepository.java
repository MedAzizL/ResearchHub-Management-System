package com.example.ResearchHub.Repositories;

import com.example.ResearchHub.Entities.Contribution;
import com.google.common.collect.ContiguousSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Long> {
    @Query("SELECT c FROM Contribution c WHERE c.article.id = :articleId")
    List<Contribution> findContributionsByArticleId(@Param("articleId") int articleId);}
