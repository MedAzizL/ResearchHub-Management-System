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
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository ArticleRepository;
    private final DomaineRepository domainRepository;  // Add this for Domain handling


    public void createArticle(CreateArticleDTO createArticleDTO) {
    //adding domain in article  builder
        Domain domain = domainRepository.findById(createArticleDTO.getDomainId())
                .orElseThrow(() -> new EntityNotFoundException("Domain with ID " + createArticleDTO.getDomainId() + " not found"));

        Article article = Article.builder()
                .doi(createArticleDTO.getDoi())
                .titre(createArticleDTO.getTitre())
                .motsCles(createArticleDTO.getMotsCles())
                .domain(domain)
                .build();

        ArticleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return ArticleRepository.findAll();
    }

    public void updateArticle(UpdateArticleDTO updateArticleDTO, Long id) {
        Article article = ArticleRepository.findById(id)
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

        ArticleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        if (!ArticleRepository.existsById(id)) {
            throw new EntityNotFoundException("Article with ID " + id + " not found");
        }
        ArticleRepository.deleteById(id);
    }

    public Optional<Article> getArticleById(Long id) {
        return ArticleRepository.findById(id);
    }
}
