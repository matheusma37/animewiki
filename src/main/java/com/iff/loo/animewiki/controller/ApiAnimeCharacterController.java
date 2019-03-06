package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.AnimeCharacter;
import com.iff.loo.animewiki.repository.Characters;
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
@RequestMapping("/api/characters")
public class ApiAnimeCharacterController {
    
    @Autowired
    private Characters characters;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<AnimeCharacter> listAllCharacters() {
        return characters.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<AnimeCharacter> getCharacter(@PathVariable("id") Long id) {
        return this.characters.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<AnimeCharacter>> listAll() {
        return new ResponseEntity<List<AnimeCharacter>>(
            new ArrayList<AnimeCharacter>(characters.findAll()), 
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") Long id) {
        Optional<AnimeCharacter> c = characters.findById(id);
        if (!c.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characters.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public  ResponseEntity<?> saveCharacter(@RequestBody AnimeCharacter character) {
        return new ResponseEntity<AnimeCharacter> (characters.save(character), HttpStatus.OK);
    }
}
