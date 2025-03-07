package com.example.ResearchHub.Services;

import com.example.ResearchHub.Entities.Domain;
import com.example.ResearchHub.Repositories.DomaineRepository;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomaineService {
    private final DomaineRepository domaineRepository;

    public List<Domain> getAllDomaines() {
        return domaineRepository.findAll();
    }

    public Domain getDomaineById(Long id) {
        return domaineRepository.findById(id).orElseThrow(() -> new RuntimeException("Domaine not found"));
    }

    public Domain createDomaine(Domain domaine) {
        return domaineRepository.save(domaine);
    }

    public void updateDomaine(Long id, Domain updatedDomaine) {
        Domain domaine = domaineRepository.findById(id).orElseThrow(() -> new RuntimeException("Domaine not found"));
        if (updatedDomaine.getNomDomaine() != null) {
            domaine.setNomDomaine(updatedDomaine.getNomDomaine());
        }
        domaineRepository.save(domaine);
    }

    public void deleteDomaine(Long id) {
        domaineRepository.deleteById(id);
    }
}
