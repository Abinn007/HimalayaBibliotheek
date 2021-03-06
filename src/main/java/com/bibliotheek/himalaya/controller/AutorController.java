package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Autor;
import com.bibliotheek.himalaya.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {

    @Autowired
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/toevoegenAutor")
    public ModelAndView toevoegenAutorHandler() {
    ModelAndView mav = new ModelAndView("autor_toevoegen");
        mav.addObject("autor",new Autor());
        return mav;
}

@PostMapping("/opslaanAutor")
    public String opslaanAutorHandler(@RequestParam String naam, Model model){
        Autor autor = new Autor();
        autor.setNaam(naam);
        if(autorService.isBestaandAutor(naam)) {
            model.addAttribute("error", "Deze autor bestaat al !");
            model.addAttribute("autor",autor);
            return "autor_toevoegen";
        }else{
            autorService.saveAutor(autor);
            return "autor_opslaan";
        }

}

}
