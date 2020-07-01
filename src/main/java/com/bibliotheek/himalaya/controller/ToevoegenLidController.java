package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.model.Student;
import com.bibliotheek.himalaya.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

@Controller
public class ToevoegenLidController {
    @Autowired
    private StudentService studentService;

    public ToevoegenLidController() {
    }

    public ToevoegenLidController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/toevoegen_lid")
    public ModelAndView handelToevoegenLid(){
        ModelAndView mav = new ModelAndView("lid_toevoegen");
        mav.addObject("nieuwStudent",new Student());
        return mav;
    }

    @PostMapping("/opslaan_lid")
    public ModelAndView lidToevoegenHandler(@RequestParam int student_nr, @RequestParam String naam,
                                            @RequestParam String geboortedatum){
        ModelAndView mav;
        Student student = new Student(student_nr,naam,geboortedatum);
        if (studentService.isBestaandeStudent(student_nr)){
            mav = new ModelAndView("lid_toevoegen");
            mav.addObject("nieuwStudent", student);
            mav.addObject("error", "Er bestaat al een lid met dit student nr.!");
        }else {
            mav = new ModelAndView("lid_registreren");
            studentService.saveStudent(student);
            mav.addObject("student",student);
        }
        return mav;
    }




}
