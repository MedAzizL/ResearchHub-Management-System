package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Dto.UpdateDomainDTO;
import com.example.ResearchHub.Entities.Domain;
import com.example.ResearchHub.Services.DomaineService;
import jakarta.persistence.EntityNotFoundException;
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
        if (domaineService.getDomaineById(id) != null){
            return ResponseEntity.ok(domaineService.getDomaineById(id));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Domain createDomaine(@RequestBody Domain domaine) {
        return domaineService.createDomaine(domaine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDomaine(@PathVariable Long id) {
        domaineService.deleteDomaine(id);
        return ResponseEntity.ok("domaine deleted successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String>Updatedomaine(@PathVariable long id, @RequestBody UpdateDomainDTO domaine){
        domaineService.updateDomaine(id,domaine);
        return ResponseEntity.ok("domaine updated successfully");
    }
}
