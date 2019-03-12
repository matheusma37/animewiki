package com.iff.loo.animewiki.repository;

import com.iff.loo.animewiki.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Photos extends JpaRepository<Photo, Long>{
    
}
