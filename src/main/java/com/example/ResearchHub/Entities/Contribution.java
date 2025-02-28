package com.example.ResearchHub.Entities;

import com.example.ResearchHub.Enum.Type_contribution;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "Contribution")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contribution {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_user_article")
    private int id_user_article;
@Column(name="type")
    private Type_contribution type;
@Column(name="date")
    private Date date;
@Column(name="lieu")
    private String lieu;

@ManyToOne
@JoinColumn(name="User_id",nullable = false)
private User user;

@ManyToOne
@JoinColumn(name="Article_id",nullable = false)
private Article article;

}
