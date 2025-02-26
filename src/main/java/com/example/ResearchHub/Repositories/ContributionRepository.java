package com.example.ResearchHub.Repositories;

import com.example.ResearchHub.Entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionRepository extends JpaRepository<Contribution,Long> {
}
