package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.service.BoekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToevoegenBoekController {
    @Autowired
    private final BoekService boekService;

    public ToevoegenBoekController(BoekService boekService) {
        this.boekService = boekService;
    }


    @GetMapping("toevoegen_boek")
    public ModelAndView invoerenBoekHandler(){
        ModelAndView mav = new ModelAndView("boek_toevoegen");
        Boek boek = new Boek();
        mav.addObject("boek", boek);
        return mav;
    }

    @PostMapping("opslaan_boek")
    public ModelAndView opslaanboekHandler(@RequestParam String title, @RequestParam String isbn, Model model ) {
        ModelAndView mav;
        Boek boek = new Boek();
        if (boekService.isBestaandIsbn(isbn)) {
            mav = new ModelAndView("boek_toevoegen");
            mav.addObject("boek", boek);
            mav.addObject("error", "Er bestaat al een boek met dit ISBN, controleren aub.");
        } else {
            mav = opslaanBoekMAV(title, isbn, boek);
        }
        return mav;
    }

    private ModelAndView opslaanBoekMAV(@RequestParam String title, @RequestParam String isbn, Boek boek) {
        ModelAndView mav;
        mav = new ModelAndView("boek_opslaan");
        boek.setGeleend(false);
        boek.setTitle(title);
        boek.setIsbn(isbn);
        boekService.saveBoek(boek);
        mav.addObject("boek", boek);
        return mav;
    }
}
