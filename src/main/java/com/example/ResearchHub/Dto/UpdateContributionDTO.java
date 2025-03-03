package com.example.ResearchHub.Dto;

import com.example.ResearchHub.Enum.Type_contribution;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateContributionDTO {
    private Type_contribution type;
    private Date date;
    private String lieu;
    private Integer id_user;
    private Long id_article;
}
