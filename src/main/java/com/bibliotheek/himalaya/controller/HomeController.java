package com.bibliotheek.himalaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    public HomeController(){
        super();
    }

    @GetMapping("/")
    public String handleHome() {
        return "home";
    }


    @GetMapping("/inloggen")
    public String handelMedewerkerLogin(){
        return "medewerker_login";
    }
}
