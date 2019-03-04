package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.AnimeCharacter;
import com.iff.loo.animewiki.repository.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/characters")
public class AnimeCharacterController {
   
    @Autowired
    Characters characters;
/* 	
    @Autowired 
    Animes animes;
*/
    @RequestMapping("")
    public ModelAndView listAll() {
            ModelAndView mv = new ModelAndView("characters-list");
            mv.addObject("character", new AnimeCharacter());
            //mv.addObject("animes",animes.findAll());
            mv.addObject("characters",characters.findAll());
            return mv;
    }
    
    @RequestMapping(value="show/{id}", method=RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
            ModelAndView mv = new ModelAndView("character-show");
            AnimeCharacter c = characters.getOne(id);
            mv.addObject(c);
            return mv;
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(AnimeCharacter c) {
            characters.save(c);
            return "redirect:/characters";
    }

    @RequestMapping(value="update/{id}")
    public ModelAndView update(@PathVariable Long id) {
            ModelAndView mv = new ModelAndView("characters-list");
            AnimeCharacter c = characters.getOne(id);
            mv.addObject(c);
            //mv.addObject("animes",animes.findAll());
            mv.addObject("characters",characters.findAll());
            return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id) {
            characters.deleteById(id);
            //attributes.addFlashAttribute("mensagem", "Proprietario excluído com sucesso!");
            return "redirect:/characters";
	}
}