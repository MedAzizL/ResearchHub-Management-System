package com.example.ResearchHub.Repositories;

import com.example.ResearchHub.Entities.Contribution;
import com.example.ResearchHub.Entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain,Long> {
}
