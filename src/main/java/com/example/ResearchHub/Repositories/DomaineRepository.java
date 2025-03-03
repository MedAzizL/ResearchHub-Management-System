package com.example.ResearchHub.Repositories;

import com.example.ResearchHub.Entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domain, Long> {
}
