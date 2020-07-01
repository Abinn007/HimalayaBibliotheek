package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Student;
import com.bibliotheek.himalaya.model.Uitlenen;
import com.bibliotheek.himalaya.service.BoekService;
import com.bibliotheek.himalaya.service.StudentService;
import com.bibliotheek.himalaya.service.UitlenenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class UitlenenBoekController {
    private static final int MAX_UITLENEN_DATUM = 15;

    @Autowired
    private BoekService boekService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UitlenenService uitlenenService;

    @GetMapping("/uitlenen_boek")
    public ModelAndView handelUitlenenBoek(@RequestParam("lidnummer") int lidnummer) {
        ModelAndView mav = new ModelAndView("uitlenen_boek_nieuw_lid");
        Student student = studentService.getStudentByLidnummer(lidnummer);
        mav.addObject("uitlenen", new Uitlenen());
        mav.addObject("lidnummer", lidnummer);
        mav.addObject("student", student);
        mav.addObject("boek", new Boek());
        return mav;
    }

    @GetMapping("/uitlenenBoek")
    public ModelAndView handelUitlenenBoek() {
        ModelAndView mav = new ModelAndView("uitlenen_boek");
        mav.addObject("uitlenen", new Uitlenen());
        mav.addObject("student", new Student());
        mav.addObject("boek", new Boek());
        return mav;
    }

    @PostMapping("/uitlenen_afgerond")
    public ModelAndView handelUitlenenBoek(@RequestParam String isbn, @RequestParam int lidnummer,
                                           @RequestParam String datumUitlening) {
        ModelAndView mav;
        Student student = studentService.getStudentByLidnummer(lidnummer);
        LocalDate parsedDatum = LocalDate.parse(datumUitlening);
        LocalDate maxLeningDatum = parsedDatum.plusDays(MAX_UITLENEN_DATUM);
        mav = getModelAndView(isbn, datumUitlening, student, maxLeningDatum);
        return mav;
    }

    private ModelAndView getModelAndView(@RequestParam String isbn, @RequestParam String datumUitlening,
                                         Student student, LocalDate maxLeningDatum) {
        ModelAndView mav;
        if (boekService.isBeschikbaar(isbn)) {
            mav = new ModelAndView("uitlenen_opslaan");
            Boek boek = boekService.getBoekByIsbn(isbn);
            boek.setGeleend(true);
            Uitlenen uitlenen = new Uitlenen(datumUitlening, null, maxLeningDatum.toString(),
                    boek, student);
            uitlenenService.save(uitlenen);
        } else {
            mav = getErrorBericht(student);
        }
        return mav;
    }

    private ModelAndView getErrorBericht(Student student) {
        ModelAndView mav;
        mav = new ModelAndView("uitlenen_boek");
        mav.addObject("uitlenen", new Uitlenen());
        mav.addObject("boek", new Boek());
        mav.addObject("student", student);
        mav.addObject("error", "Dit boek is niet beschikbaar !");
        return mav;
    }

    @GetMapping("/uitlenigLijst")
    public String uitleningLijstHandler(Model model) {
        model.addAttribute("uitleningLijst", uitlenenService.getAllUitlenen());
        return "uitlenenLijst";

    }

    @GetMapping("/boek_terugbrengen")
    public ModelAndView handelTerugbrengenBoek() {
        ModelAndView mav = new ModelAndView("terugbrengen_boek");
        mav.addObject("uitlenen", new Uitlenen());
        mav.addObject("boek", new Boek());
        return mav;
    }

    @PostMapping("/boek_terugbrengen_opslaan")
    public ModelAndView boekTerugBrengenHandler(@RequestParam String datumTerugGebracht, @RequestParam String isbn) {
        ModelAndView mav;
        if (boekService.isUitgeleend(isbn)) {
            mav = getOpslaanTerugbrengenMAV(datumTerugGebracht, isbn);
        } else {
            mav = new ModelAndView("terugbrengen_boek");
            mav.addObject("uitlenen", new Uitlenen());
            mav.addObject("boek", new Boek());
            mav.addObject("error", "Het BSN klopt niet !");
        }
        return mav;

    }

    private ModelAndView getOpslaanTerugbrengenMAV(@RequestParam String datumTerugGebracht, @RequestParam String isbn) {
        ModelAndView mav;
        mav = new ModelAndView("terugbrengen_boek_opslaan");
        Boek boek = boekService.getBoekByIsbn(isbn);
        Uitlenen uitlenen = uitlenenService.findByBoekId(boek.getId());
        uitlenen.setDatumTerugGebracht(datumTerugGebracht);
        uitlenenService.terugbrengenBoek(uitlenen);
        return mav;
    }

    @GetMapping("/boek_verlengen")
    public ModelAndView handelVerlengenBoek() {
        ModelAndView mav = new ModelAndView("verlengen_boek");
        mav.addObject("boek", new Boek());
        return mav;
    }


    @PostMapping("/boek_verlengen_opslaan")
    public ModelAndView boekTerugBrengenHandler(@RequestParam String isbn) {
        ModelAndView mav;
        if (boekService.isUitgeleend(isbn)) {
            mav = opslaanBoekVerlengenMAV(isbn);
        } else {
            mav = getErrorMAV("Het ISBN klopt niet !");
        }
        return mav;
    }

    private ModelAndView opslaanBoekVerlengenMAV(@RequestParam String isbn) {
        ModelAndView mav;
        mav = new ModelAndView("verlengen_boek_opslaan");
        Boek boek = boekService.getBoekByIsbn(isbn);
        Uitlenen uitlenen = uitlenenService.findByBoekId(boek.getId());
        if (uitlenenService.uitgeleendDagen(uitlenen.getId()) <= 15) {
            String nieuweMaxLeningDatum = uitlenenService.verlengenBoek(uitlenen);
            mav.addObject("nieuweMaxLeningDatum", nieuweMaxLeningDatum);
        } else {
            mav = getErrorMAV("Het is al 1 keer verlengd !");
        }
        return mav;
    }

    private ModelAndView getErrorMAV(String error) {
        ModelAndView mav;
        mav = new ModelAndView("verlengen_boek");
        mav.addObject("error", error);
        mav.addObject("boek", new Boek());
        return mav;
    }
}