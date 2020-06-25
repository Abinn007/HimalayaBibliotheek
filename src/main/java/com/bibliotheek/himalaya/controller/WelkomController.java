package com.bibliotheek.himalaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelkomController {


    public WelkomController() {
    }

    @GetMapping("welkom_pagina")
    public String welkomHandler(){
        return "welkom_pagina";
    }
}
