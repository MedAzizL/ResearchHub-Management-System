package com.example.ResearchHub.Controllers;
import com.example.ResearchHub.Dto.CreateArticleDTO;
import com.example.ResearchHub.Dto.UpdateArticleDTO;
import com.example.ResearchHub.Entities.Article;
import com.example.ResearchHub.Services.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<String> createArticle(@RequestBody CreateArticleDTO createArticleDTO) {
        articleService.createArticle(createArticleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Article created successfully");
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArticle(@RequestBody UpdateArticleDTO updateArticleDTO, @PathVariable Long id) {
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
