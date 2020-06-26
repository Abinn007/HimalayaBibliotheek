package com.bibliotheek.himalaya.controller;

import com.bibliotheek.himalaya.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LedenlijstController {
    @Autowired
    private final StudentService studentService;

    public LedenlijstController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/ledenLijst")
    public String ledenLijstHandler(Model model) {
        model.addAttribute("ledenLijst", studentService.getStudentLijst());
        return "ledenLijst";

    }



}
