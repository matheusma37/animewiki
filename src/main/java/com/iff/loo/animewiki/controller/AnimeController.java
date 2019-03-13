package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.Anime;
import com.iff.loo.animewiki.model.AnimePhoto;
import com.iff.loo.animewiki.repository.Animes;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.iff.loo.animewiki.repository.AnimePhotos;

@Controller
@RequestMapping("/animes")
public class AnimeController {
    
    @Autowired
    Animes animes;
    
    @Autowired 
    AnimePhotos photos;

    @RequestMapping("")
    public ModelAndView listAll() {
            ModelAndView mv = new ModelAndView("anime/animes-list");
            mv.addObject("anime", new Anime());
            mv.addObject("animes",animes.findAll());
            return mv;
    }
    
    @RequestMapping(value="show/{id}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
            ModelAndView mv = new ModelAndView("anime/anime-show");
            mv.addObject("anime", animes.getOne(id));
            return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(Anime a,
            @RequestParam("file") MultipartFile imageFile) {
        if(imageFile.isEmpty()){
            return "redirect:/animes";
        }
        AnimePhoto photo = new AnimePhoto();
        photo.setName(imageFile.getOriginalFilename());
        try {
            photo.setFile(imageFile.getBytes());
        } catch (IOException ex) {
            return "redirect:/animes";
        }
        a.setPhoto(photo);
        animes.save(a);
        return "redirect:/animes";
    }

    @RequestMapping(value="update/{id}")
    public ModelAndView update(@PathVariable Long id) {
            ModelAndView mv = new ModelAndView("anime/anime-edit");
            mv.addObject("anime", animes.getOne(id));
            return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id) {
            animes.deleteById(id);
            return "redirect:/animes";
	}
}
