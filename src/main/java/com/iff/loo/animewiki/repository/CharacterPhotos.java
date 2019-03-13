package com.iff.loo.animewiki.repository;

import com.iff.loo.animewiki.model.CharacterPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterPhotos extends JpaRepository<CharacterPhoto, Long>{
    
}
