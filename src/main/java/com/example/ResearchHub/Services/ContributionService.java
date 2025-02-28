package com.example.ResearchHub.Services;

import com.example.ResearchHub.Entities.Contribution;
import com.example.ResearchHub.Repositories.ContributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContributionService {
    public final ContributionRepository contributionRepository;

    public List<Contribution> getAllContribution(){
        return contributionRepository.findAll();
    }
    public void createContribution(Contribution )

    public Optional<Contribution> getContributionbyId(int id){
        return contributionRepository.findById((long) id);
    }
    public void deleteContribution(Contribution contribution){
        contributionRepository.delete(contribution);
    }

}
