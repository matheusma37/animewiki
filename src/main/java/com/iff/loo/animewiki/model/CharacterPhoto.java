package com.iff.loo.animewiki.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CharacterPhoto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "anime_character_id")
    private AnimeCharacter character;
    
    @NotNull(message = "Nome é obrigatório!")
    private String name;

    @NotNull(message = "O arquivo é obrigatório!")
    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] file;

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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public AnimeCharacter getCharacter() {
        return character;
    }

    public void setCharacter(AnimeCharacter character) {
        this.character = character;
    }
}
