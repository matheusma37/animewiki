package com.iff.loo.animewiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iff.loo.animewiki.model.AnimeCharacter;

public interface Characters extends JpaRepository<AnimeCharacter, Long>{
    
}
