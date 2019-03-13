package com.iff.loo.animewiki.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AnimeCharacter implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "anime_id")
    @NotNull(message = "Anime é obrigatório!")
    private Anime anime;  
    
    @NotNull(message = "Nome é obrigatório!")
    @Column(length=100)
    private String name;
    
    @NotNull(message = "A descrição é obrigatória!")
    @Column(length=500)
    private String description;
    
    @Column(length=100)
    private String favoriteFood;
    
    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @NotNull(message = "Foto é obrigatória!")
    private CharacterPhoto photo;
    
    @Column(precision=2, scale=2)
    private float height;
    
    @Column(precision=10, scale=2)
    private float weight;
    
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public CharacterPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(CharacterPhoto photo) {
        this.photo = photo;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}
