package com.example.ResearchHub.Services;

import com.example.ResearchHub.Dto.Contribution_BY_ArticleDTO;
import com.example.ResearchHub.Dto.CreateContributionDTO;
import com.example.ResearchHub.Dto.UpdateContributionDTO;
import com.example.ResearchHub.Entities.Article;
import com.example.ResearchHub.Entities.Contribution;
import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Repositories.ArticleRepository;
import com.example.ResearchHub.Repositories.ContributionRepository;
import com.example.ResearchHub.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContributionService {

    public final ContributionRepository contributionRepository;
    public final ArticleRepository articleRepository;
    public final UserRepository userRepository;

    public List<Contribution> getAllContribution(){
        return contributionRepository.findAll();
    }
    public void createContribution(CreateContributionDTO contributionDTO){
        User user = userRepository.findById(contributionDTO.getId_user()).orElseThrow(()-> new RuntimeException("User not Found"));
        Article article =  articleRepository.findById((long) contributionDTO.getId_article()).orElseThrow( () -> new RuntimeException("Article not found")  );

                Contribution contribution = Contribution.builder()
                     //   .type(contributionDTO.getType())
                                .date(contributionDTO.getDate())
                                    //    .lieu(contributionDTO.getLieu())
                                                .user(user)
                                                    .article(article)
                                                                .build();
        contributionRepository.save(contribution);
    }
    public void updateContribution(UpdateContributionDTO updateContributionDTO,int id){
        Contribution c = contributionRepository.findById((long)id).orElseThrow(()->new RuntimeException("contribution not found"));
       /* if (updateContributionDTO.getType() != null){
            c.setType(updateContributionDTO.getType());
        }*/
        if (updateContributionDTO.getDate() != null){
            c.setDate(updateContributionDTO.getDate());
        }
        /*if (updateContributionDTO.getLieu() != null){
            c.setLieu(updateContributionDTO.getLieu());
        }*/
        if (updateContributionDTO.getId_user() != null ){
            User user = userRepository.findById(updateContributionDTO.getId_user()).orElseThrow(()-> new RuntimeException("User not Found"));
            c.setUser(user);
        }
        if (updateContributionDTO.getId_article() != null){
            Article a = articleRepository.findById(updateContributionDTO.getId_article()).orElseThrow(() -> new RuntimeException("Article not found"));
            c.setArticle(a);
        }
        contributionRepository.save(c);
    }

    public Contribution getContributionbyId(int id){
        Contribution c = contributionRepository.findById((long) id).orElseThrow(()->new RuntimeException("Contribution not found"));
        return c;
    }

    public List<Contribution_BY_ArticleDTO> getContributionbyarticleid(int id){
        List<Contribution> listcontribution = contributionRepository.findContributionsByArticleId(id);

        List<Contribution_BY_ArticleDTO> dtoList = new ArrayList<>();
        for (Contribution contribution : listcontribution) {
            User user = contribution.getUser();
            dtoList.add(new Contribution_BY_ArticleDTO(user));
        }
        return dtoList;
    }

    public void deleteContribution(Contribution contribution){
        contributionRepository.delete(contribution);
    }

}
