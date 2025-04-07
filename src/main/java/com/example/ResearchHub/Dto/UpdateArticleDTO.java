package com.example.ResearchHub.Dto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile pdfDocument;

}