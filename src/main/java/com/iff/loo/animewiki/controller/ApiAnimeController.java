package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.Anime;
import com.iff.loo.animewiki.repository.Animes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
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
    
    @RequestMapping(value = "/anime/photo/{id}",
            method = RequestMethod.GET)
    public void getPhoto(@PathVariable("id") Long id,
            HttpServletResponse response) throws IOException {
        
        Path absolutePath = Paths.get("").toAbsolutePath();
        byte[] file;
        try{    
            file = Files.readAllBytes(Paths.get(absolutePath +
                                "/src/main/resources/static/images/" +
                                "anime/" + animes.getOne(id).getPhoto()
                            )
                        );
        }catch(Exception ex){
            file = Files.readAllBytes(Paths.get(absolutePath +
                                "/src/main/resources/static/images/anime/group.jpg"
                            )
                        );
        }
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(file);
        response.getOutputStream().close();
    }

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
        if(anime.getPhoto() == null){
            anime.setPhoto("group.jpg");
        }
        return new ResponseEntity<Anime>(animes.save(anime), HttpStatus.OK);
    }
}
