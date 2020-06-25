package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.service.MedewerkerService;
import com.bibliotheek.himalaya.utilities.MedewerkerLoginBackingBean;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes ("medewerker")
public class InloggenMedewerkerController {

    @Autowired
    private final MedewerkerService medewerkerService;

    public InloggenMedewerkerController(){
        this(null);
    }

    public InloggenMedewerkerController(MedewerkerService medewerkerService){
        this.medewerkerService = medewerkerService;
    }
    //        MedewerkerLoginBackingBean backingBean = new MedewerkerLoginBackingBean();
//        mav.addObject("backingBean", backingBean);
//        Medewerker medewerker = new Medewerker("A","sariga","sarigas","12345");
//        medewerkerService.saveMedewerker(medewerker);



    @PostMapping("/login_medewerker")
    public ModelAndView HandelHoofdpagina(@RequestParam String gebruikersnaam, @RequestParam String wachtwoord) {
        ModelAndView mav;
        Medewerker currentMedewerker = medewerkerService.getMedewerkerByGebruikersnaam(gebruikersnaam);
        if (currentMedewerker != null && currentMedewerker.getGebruikersnaam().equals(gebruikersnaam)
                && currentMedewerker.getWachtwoord().equals(wachtwoord)){
            mav = new ModelAndView("welkom_pagina");
            mav.addObject("medewerker",currentMedewerker);
        }else{
            mav = new ModelAndView("mislukt_inloggen");
            mav.addObject("login_error","Gebruikersnaam of/en wacthwoord onjuist ! ");
        }
        return mav;
    }

}
