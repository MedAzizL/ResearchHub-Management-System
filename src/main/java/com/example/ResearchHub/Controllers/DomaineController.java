package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Entities.Domain;
import com.example.ResearchHub.Services.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domaines")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @GetMapping
    public List<Domain> getAllDomaines() {
        return domaineService.getAllDomaines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domain> getDomaineById(@PathVariable Long id) {
        Domain domaine = domaineService.getDomaineById(id);
        return domaine != null ? ResponseEntity.ok(domaine) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Domain createDomaine(@RequestBody Domain domaine) {
        return domaineService.createDomaine(domaine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomaine(@PathVariable Long id) {
        domaineService.deleteDomaine(id);
        return ResponseEntity.noContent().build();
    }
}
