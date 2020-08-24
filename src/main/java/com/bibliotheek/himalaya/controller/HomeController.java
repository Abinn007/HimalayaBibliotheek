package com.bibliotheek.himalaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
