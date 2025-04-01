package com.example.ResearchHub.Controllers;
import com.example.ResearchHub.Dto.CreateArticleDTO;
import com.example.ResearchHub.Dto.UpdateArticleDTO;
import com.example.ResearchHub.Entities.Article;
import com.example.ResearchHub.Services.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createArticle(
            @RequestPart("articleData") String  articleData,
            @RequestPart("pdfDocument") MultipartFile pdfDocument) throws IOException {

        // Convert articleData JSON string to DTO
        ObjectMapper objectMapper = new ObjectMapper();
        CreateArticleDTO createArticleDTO = objectMapper.readValue(articleData, CreateArticleDTO.class);

        // Set the file in the DTO
        createArticleDTO.setPdfDocument(pdfDocument);

        articleService.createArticle(createArticleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Article created successfully");
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateArticle(
            @RequestPart("UpdateArticleData") String updateArticleData,
            @RequestPart(value = "pdfDocument", required = false) MultipartFile pdfDocument,
            @PathVariable Long id) throws IOException {

        // Convert articleData JSON string to DTO
        ObjectMapper objectMapper = new ObjectMapper();
        UpdateArticleDTO updateArticleDTO = objectMapper.readValue(updateArticleData, UpdateArticleDTO.class);

        // Set the file if provided
        if (pdfDocument != null) {
            updateArticleDTO.setPdfDocument(pdfDocument);
        }

        articleService.updateArticle(updateArticleDTO, id);
        return ResponseEntity.ok("Article updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok("Article deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Article with ID " + id + " not found"));
    }
}
