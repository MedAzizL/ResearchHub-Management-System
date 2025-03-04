package com.example.ResearchHub.Dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateArticleDTO {
    private String doi;

    private String titre;

    private String motsCles;

    private Long domainId;

}