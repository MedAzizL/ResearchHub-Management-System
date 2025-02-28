package com.example.ResearchHub.Dto;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateArticleDTO {

    private String doi;

    private String titre;

    private String motsCles;
}
