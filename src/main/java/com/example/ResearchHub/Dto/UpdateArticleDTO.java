package com.example.ResearchHub.Dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateArticleDTO {
    // fields are optional and can be updated individually
    private String doi;

    private String titre;

    private String motsCles;
}