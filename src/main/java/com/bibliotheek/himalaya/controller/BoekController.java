package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.service.BoekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoekController {
    @Autowired
    private final BoekService boekService;

    public BoekController(BoekService boekService) {
        this.boekService = boekService;
    }

    @GetMapping("/boekenLijst")
    public String boekenLijstHandler(Model model) {
        model.addAttribute("boekLijst", boekService.getAllBoeken());
        return "boekenLijst";

    }

    @GetMapping("/geleende_boekenLijst")
    public String geleendeBoekenLijstHandler(Model model) {
        model.addAttribute("geleendBoekLijst", boekService.geleendBoekenLijst());
        return "geleendeBoekenLijst";

    }

    @GetMapping("/niet_geleende_boekenLijst")
    public String nietGeleendeBoekenLijstHandler(Model model) {
        model.addAttribute("nietGeleendBoekLijst", boekService.nietGeleendBoekenLijst());
        return "nietGeleendeBoekenLijst";

    }

}
