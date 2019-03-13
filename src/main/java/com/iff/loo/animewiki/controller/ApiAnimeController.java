package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.Anime;
import com.iff.loo.animewiki.model.AnimePhoto;
import com.iff.loo.animewiki.repository.AnimePhotos;
import com.iff.loo.animewiki.repository.Animes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animes")
public class ApiAnimeController {
    
    @Autowired
    private Animes animes;
    
    @Autowired
    private AnimePhotos photos;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Anime> listAllAnimes() {
        return animes.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Anime> getAnime(@PathVariable("id") Long id) {
        return this.animes.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Anime>> listAll() {
        return new ResponseEntity<List<Anime>>(
            new ArrayList<Anime>(animes.findAll()), 
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnime(@PathVariable("id") Long id) {
        Optional<Anime> a = animes.findById(id);
        if (!a.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        animes.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public  ResponseEntity<?> saveAnime(@RequestBody Anime anime) {
        AnimePhoto photo = anime.getPhoto();
        photos.save(photo);
        animes.save(anime);
        photo.setAnime(anime);
        anime.setPhoto(photo);
        photos.save(photo);
        return new ResponseEntity<Anime>(animes.save(anime), HttpStatus.OK);
    }
}
