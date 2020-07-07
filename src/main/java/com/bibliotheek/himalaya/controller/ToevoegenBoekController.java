package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Autor;
import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.service.AutorService;
import com.bibliotheek.himalaya.service.BoekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToevoegenBoekController {
    @Autowired
    private final BoekService boekService;
    @Autowired
    private final AutorService autorService;

    public ToevoegenBoekController(BoekService boekService, AutorService autorService) {
        this.boekService = boekService;
        this.autorService = autorService;
    }


    @GetMapping("/toevoegen_boek")
    public ModelAndView invoerenBoekHandler(){
        ModelAndView mav = new ModelAndView("boek_toevoegen");
        Boek boek = new Boek();
        List<Autor> autorList = autorService.getAll();
        mav.addObject("boek", boek);
        mav.addObject("autors_lijst", autorList);
        mav.addObject("autor",new Autor());
        return mav;
    }

    @PostMapping("/opslaan_boek")
    public ModelAndView opslaanboekHandler(@RequestParam String title, @RequestParam String isbn,
                                           @RequestParam List<Autor> autors, Model model ) {
        ModelAndView mav;
        Boek boek = new Boek(title,isbn);
        List<Autor> autorList = autorService.getAll();
        if (boekService.isBestaandIsbn(isbn)) {
            mav = new ModelAndView("boek_toevoegen");
            mav.addObject("boek", boek);
            mav.addObject("autors_lijst", autorList);
            mav.addObject("error", "Er bestaat al een boek met dit ISBN, controleren aub.");
        } else {
            mav = opslaanBoekMAV(title, isbn, boek, autors);
        }
        return mav;
    }

    private ModelAndView opslaanBoekMAV(@RequestParam String title, @RequestParam String isbn, Boek boek, List<Autor> autors) {
        ModelAndView mav;
        mav = new ModelAndView("boek_opslaan");
        boek.setGeleend(false);
        boek.setTitle(title);
        boek.setIsbn(isbn);
        for (Autor autor : autors) {
            autor.toevoegenBoek(boek);
        }
        boekService.saveBoek(boek);
        mav.addObject("boek", boek);
        return mav;
    }
    @PostMapping("/toevoegen_autor")
    public ModelAndView toevoegenAutorHandler() {
        ModelAndView mav = new ModelAndView("autorToevoegen");
        mav.addObject("autor",new Autor());
        return mav;
    }

    @PostMapping("/opslaan_autor")
    public ModelAndView opslaanAutorHandler(@RequestParam String naam){
        ModelAndView mav = new ModelAndView("boek_toevoegen");
        Autor autor = new Autor();
        autor.setNaam(naam);
        autorService.saveAutor(autor);
        Boek boek = new Boek();
        List<Autor> autorList = autorService.getAll();
        mav.addObject("boek", boek);
        mav.addObject("autors_lijst", autorList);
        mav.addObject("autor",new Autor());
        return mav;
    }
}
