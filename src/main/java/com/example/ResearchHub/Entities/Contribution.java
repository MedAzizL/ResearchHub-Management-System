package com.example.ResearchHub.Entities;

import com.example.ResearchHub.Enum.Type_contribution;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Contribution")
public class Contribution {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_user_article")
    private int id_user_article;
@Column(name="type")
    private Type_contribution type;
@Column(name="date")
    private Date date;
@Column(name="Lieu")
    private String lieu;

    public Contribution(int id_user_article, Type_contribution type, Date date, String lieu) {
        this.id_user_article = id_user_article;
        this.type = type;
        this.date = date;
        this.lieu = lieu;
    }

    public int getId_user_article() {
        return id_user_article;
    }

    public Type_contribution getType() {
        return type;
    }

    public void setType(Type_contribution type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
