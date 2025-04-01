package com.example.ResearchHub.Services;

import com.example.ResearchHub.Dto.CreateArticleDTO;
import com.example.ResearchHub.Dto.UpdateArticleDTO;
import com.example.ResearchHub.Entities.Article;
import com.example.ResearchHub.Entities.Domain;
import com.example.ResearchHub.Repositories.ArticleRepository;
import com.example.ResearchHub.Repositories.DomaineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final DomaineRepository domainRepository;

    public void createArticle(CreateArticleDTO createArticleDTO) throws IOException {
        Domain domain = domainRepository.findById(createArticleDTO.getDomainId())
                .orElseThrow(() -> new EntityNotFoundException("Domain not found"));

        // Validate PDF
        MultipartFile pdfFile = createArticleDTO.getPdfDocument();
        if (pdfFile == null || pdfFile.isEmpty()) {
            throw new IllegalArgumentException("PDF document is required");
        }
        if (!"application/pdf".equals(pdfFile.getContentType())) {
            throw new IllegalArgumentException("Only PDF files are allowed");
        }

        Article article = Article.builder()
                .doi(createArticleDTO.getDoi())
                .titre(createArticleDTO.getTitre())
                .motsCles(createArticleDTO.getMotsCles())
                .domain(domain)
                .pdfDocument(pdfFile.getBytes())
                .documentName(pdfFile.getOriginalFilename())
                .documentType(pdfFile.getContentType())
                .build();

        articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public void updateArticle(UpdateArticleDTO updateArticleDTO, Long id) throws IOException {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article with ID " + id + " not found"));

        if (updateArticleDTO.getDoi() != null) {
            article.setDoi(updateArticleDTO.getDoi());
        }
        if (updateArticleDTO.getTitre() != null) {
            article.setTitre(updateArticleDTO.getTitre());
        }
        if (updateArticleDTO.getMotsCles() != null) {
            article.setMotsCles(updateArticleDTO.getMotsCles());
        }
        if (updateArticleDTO.getDomainId() != null) {
            Domain domain = domainRepository.findById(updateArticleDTO.getDomainId())
                    .orElseThrow(() -> new EntityNotFoundException("Domain with ID " + updateArticleDTO.getDomainId() + " not found"));
            article.setDomain(domain);
        }
        if (updateArticleDTO.getPdfDocument() != null && !updateArticleDTO.getPdfDocument().isEmpty()) {
            MultipartFile pdfFile = updateArticleDTO.getPdfDocument();
            if (!"application/pdf".equals(pdfFile.getContentType())) {
                throw new IllegalArgumentException("Only PDF files are allowed");
            }
            article.setPdfDocument(pdfFile.getBytes());
            article.setDocumentName(pdfFile.getOriginalFilename());
            article.setDocumentType(pdfFile.getContentType());
        }

        articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new EntityNotFoundException("Article with ID " + id + " not found");
        }
        articleRepository.deleteById(id);
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public byte[] getArticlePdf(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article with ID " + id + " not found"));
        return article.getPdfDocument();
    }

    public Article getArticleByDoi(String doi) {
        return articleRepository.findByDoi(doi)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with DOI: " + doi));
    }


}