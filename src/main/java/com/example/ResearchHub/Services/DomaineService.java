package com.example.ResearchHub.Services;

import com.example.ResearchHub.Entities.Domain;
import com.example.ResearchHub.Repositories.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomaineService {
    @Autowired
    private DomaineRepository domaineRepository;

    public List<Domain> getAllDomaines() {
        return domaineRepository.findAll();
    }

    public Domain getDomaineById(Long id) {
        return domaineRepository.findById(id).orElse(null);
    }

    public Domain createDomaine(Domain domaine) {
        return domaineRepository.save(domaine);
    }

    public void deleteDomaine(Long id) {
        domaineRepository.deleteById(id);
    }
}
