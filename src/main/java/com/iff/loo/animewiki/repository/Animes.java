package com.iff.loo.animewiki.repository;

import com.iff.loo.animewiki.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Animes extends JpaRepository<Anime, Long>{
    
}
