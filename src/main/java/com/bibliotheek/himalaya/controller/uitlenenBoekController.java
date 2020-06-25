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

@Controller
public class uitlenenBoekController {

    @Autowired
    private BoekService boekService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UitlenenService uitlenenService;

    @GetMapping("/uitlenen_boek")
    public ModelAndView handelUitlenenBoek(@RequestParam("lidnummer") int lidnummer) {
        ModelAndView mav = new ModelAndView("uitlenen_boek");
        Student student = studentService.getStudentByLidnummer(lidnummer);
        mav.addObject("uitlenen",new Uitlenen());
        mav.addObject("student",student);
        mav.addObject("boek", new Boek());
        return mav;
    }
    @GetMapping("/uitlenenBoek")
    public ModelAndView handelUitlenenBoek() {
        ModelAndView mav = new ModelAndView("uitlenen_boek");
        mav.addObject("uitlenen",new Uitlenen());
        mav.addObject("student",new Student());
        mav.addObject("boek", new Boek());
        return mav;
    }

    @PostMapping("/uitlenen_afgerond")
    public ModelAndView handelUitlenenBoek(@RequestParam int isbn,@RequestParam int lidnummer,
                                           @RequestParam String datumUitlening) {
        ModelAndView mav = null;
        Student student = studentService.getStudentByLidnummer(lidnummer);
        if (boekService.isValidIsdn(isbn)) {
            mav = new ModelAndView("uitlenen_opslaan");
            Boek boek = boekService.getBoekByIsdn(isbn);
            boek.setGeleend(true);
            mav.addObject("student", student);
            Uitlenen uitlenen = new Uitlenen(datumUitlening, null, boek, student);
            uitlenenService.save(uitlenen);
        } else {
            mav = getErrorBericht(student);
        }
        return mav;
    }

    private ModelAndView getErrorBericht(Student student) {
        ModelAndView mav;
        mav = new ModelAndView("uitlenen_boek");
        mav.addObject("uitlenen",new Uitlenen());
        mav.addObject("boek",new Boek());
        mav.addObject("student",student);
        mav.addObject("error", "Er is geen boek met dit isbn!");
        return mav;
    }

}
