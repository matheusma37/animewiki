/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iff.loo.animewiki.controller;

import com.iff.loo.animewiki.model.AnimePhoto;
import com.iff.loo.animewiki.model.CharacterPhoto;
import com.iff.loo.animewiki.repository.AnimePhotos;
import com.iff.loo.animewiki.repository.CharacterPhotos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myImage")
public class ImageController {

    @Autowired
    AnimePhotos animePhotos;
    
    @Autowired
    CharacterPhotos characterPhotos;
    
    @RequestMapping(value = "/anime/imageDisplay", method = RequestMethod.GET)
    public void showAnimeImage(@RequestParam("id") Long id, HttpServletResponse response,HttpServletRequest request) 
            throws ServletException, IOException{

        AnimePhoto photo = animePhotos.getOne(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(photo.getFile());

        response.getOutputStream().close();
    }
    
    @RequestMapping(value = "/character/imageDisplay", method = RequestMethod.GET)
    public void showCharacterImage(@RequestParam("id") Long id, HttpServletResponse response,HttpServletRequest request) 
            throws ServletException, IOException{

        CharacterPhoto photo = characterPhotos.getOne(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(photo.getFile());

        response.getOutputStream().close();
    }
}