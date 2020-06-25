package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.repositories.MedewerkerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MedewerkerServiceTest {
    //@Autowired
    MedewerkerService medewerkerService;

    @Test
    void findGebruikerByGebruikersnaam () {
        Medewerker medewerker = new Medewerker("B.S.", "Beek","barty","beek12345");
        medewerkerService.saveMedewerker(medewerker);
        String expected = "beek12345";
        String actual = medewerkerService.getWachtwoordByGebruikersNaam("barty");
        assertEquals(expected,actual);
    }



}