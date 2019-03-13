package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.AnimeCharacter;
import com.iff.loo.animewiki.model.CharacterPhoto;
import com.iff.loo.animewiki.repository.Animes;
import com.iff.loo.animewiki.repository.Characters;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.iff.loo.animewiki.repository.CharacterPhotos;

@Controller
@RequestMapping("/characters")
public class AnimeCharacterController {
   
    @Autowired
    Characters characters;
    
    @Autowired 
    Animes animes;
    
    @Autowired 
    CharacterPhotos photos;

    @RequestMapping("")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("character/characters-list");
        mv.addObject("character", new AnimeCharacter());
        mv.addObject("animes",animes.findAll());
        mv.addObject("characters",characters.findAll());
        return mv;
    }
    
    @RequestMapping(value="show/{id}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("character/character-show");
        mv.addObject("animes",animes.findAll());
        mv.addObject("character", characters.getOne(id));
        return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(AnimeCharacter c,
            @RequestParam("file") MultipartFile imageFile) {
        if(imageFile.isEmpty()){
            return "redirect:/characters";
        }
        CharacterPhoto photo = new CharacterPhoto();
        photo.setName(imageFile.getOriginalFilename());
        try {
            photo.setFile(imageFile.getBytes());
        } catch (IOException ex) {
            return "redirect:/characters";
        }
        c.setPhoto(photo);
        characters.save(c);
        return "redirect:/characters";
    }

    @RequestMapping(value="update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("character/character-edit");
        mv.addObject("animes",animes.findAll());
        mv.addObject("character", characters.getOne(id));
        return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id) {
        characters.deleteById(id);
        return "redirect:/characters";
    }
}
