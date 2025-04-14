package com.example.ResearchHub.Entities;

import com.example.ResearchHub.Enum.Type_contribution;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name= "Contribution")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contribution {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_user_article")
    private int id_user_article;
//@Column(name="type")
  //  private Type_contribution type;
@Column(name="date")
    private Date date;
//@Column(name="lieu")
  //  private String lieu;

    @ManyToOne
    @JoinColumn(name="User_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="Article_id", nullable = false)
    @JsonIgnore
    private Article article;

    @JsonProperty("userId")
    public int getUserId() {
        return user != null ? user.getId() : null;
    }

    @JsonProperty("articleId")
    public Long getArticleId() {
        return article != null ? article.getId() : null;
    }



}
