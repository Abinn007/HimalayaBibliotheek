//package com.bibliotheek.himalaya.controller;
//
//import com.bibliotheek.himalaya.model.Medewerker;
//import com.bibliotheek.himalaya.service.MedewerkerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@SessionAttributes ("medewerker")
//public class InloggenMedewerkerController {
//
//    @Autowired
//    private final MedewerkerService medewerkerService;
//
//    public InloggenMedewerkerController(){
//        this(null);
//    }
//
//    public InloggenMedewerkerController(MedewerkerService medewerkerService){
//        this.medewerkerService = medewerkerService;
//    }
//
//    @RequestMapping("/login_medewerker")
//    public ModelAndView HandelHoofdpagina(@RequestParam String gebruikersnaam, @RequestParam String wachtwoord) {
//        ModelAndView mav;
//        Medewerker currentMedewerker = medewerkerService.getMedewerkerByGebruikersnaam(gebruikersnaam);
//        if (currentMedewerker != null && currentMedewerker.getGebruikersnaam().equals(gebruikersnaam)
//                && currentMedewerker.getWachtwoord().equals(wachtwoord)){
//            mav = new ModelAndView("welkom_pagina");
//            mav.addObject("medewerker",currentMedewerker);
//        }else{
//            mav = new ModelAndView("medewerker_login");
//            mav.addObject("medewerker", new Medewerker());
//            mav.addObject("login_error","Gebruikersnaam of/en wacthwoord onjuist ! ");
//        }
//        return mav;
//    }
//
//}
