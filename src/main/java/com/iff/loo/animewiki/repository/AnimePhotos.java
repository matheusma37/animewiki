package com.iff.loo.animewiki.repository;

import com.iff.loo.animewiki.model.AnimePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimePhotos extends JpaRepository<AnimePhoto, Long>{
    
}
