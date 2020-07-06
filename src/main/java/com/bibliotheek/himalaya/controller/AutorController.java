package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Autor;
import com.bibliotheek.himalaya.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

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
    public String opslaanAutorHandler(@RequestParam String naam){
        Autor autor = new Autor();
        autor.setNaam(naam);
        autorService.saveAutor(autor);
        return "autor_opslaan";
}

}
