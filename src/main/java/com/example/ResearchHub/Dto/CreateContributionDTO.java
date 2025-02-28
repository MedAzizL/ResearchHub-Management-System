package com.example.ResearchHub.Dto;

import com.example.ResearchHub.Enum.Type_contribution;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContributionDTO {
    private Type_contribution type;
    private Date date;
    private String lieu;
    private int id_user;
    private int id_article;
}
