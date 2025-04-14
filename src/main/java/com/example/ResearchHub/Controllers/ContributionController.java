package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Dto.Contribution_BY_ArticleDTO;
import com.example.ResearchHub.Dto.CreateContributionDTO;
import com.example.ResearchHub.Dto.UpdateContributionDTO;
import com.example.ResearchHub.Entities.Contribution;
import com.example.ResearchHub.Services.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contribution")
@RequiredArgsConstructor
public class ContributionController {

   private final ContributionService service;

   @PostMapping
   public ResponseEntity<String> createContribution(@RequestBody CreateContributionDTO createContributionDTO) {
      service.createContribution(createContributionDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("Contribution created successfully");
   }
   @PutMapping("/{id}")
   public ResponseEntity<String> updateContribution(@RequestBody UpdateContributionDTO updateContributionDTO,@PathVariable int id) {
      service.updateContribution(updateContributionDTO,id);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("Contribution Updated successfully");
   }

   @GetMapping
   public List<Contribution> getAllContribution(){
      return service.getAllContribution();
   }

   @GetMapping("/{id}")
   public Contribution getContribution(@PathVariable int id){
      return service.getContributionbyId(id);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deletecontribution(@PathVariable int id)
   {
      service.deleteContribution(service.getContributionbyId(id));
      return ResponseEntity.ok("Contribution deleted successfully");
   }

   @GetMapping("/article/{id}")
   public List<Contribution_BY_ArticleDTO> getContributionbyarticle(@PathVariable int id){
      return service.getContributionbyarticleid(id);
   }

}
