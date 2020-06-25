package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.repositories.MedewerkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedewerkerService {

    @Autowired
    private final MedewerkerRepository medewerkerRepository;

    public MedewerkerService(){
        this(null);
    }
    public MedewerkerService(MedewerkerRepository medewerkerRepository){
        this.medewerkerRepository=medewerkerRepository;
    }

    public Medewerker getMedewerkerByGebruikersnaam(String gebruikersnaam){
        return medewerkerRepository.findMedewerkerByGebruikersnaam(gebruikersnaam);
    }
    public String getWachtwoordByGebruikersNaam( String gebruikersnaam) {
        Optional<Medewerker> optionalMedewerker = Optional.ofNullable(medewerkerRepository.findMedewerkerByGebruikersnaam(gebruikersnaam));
        if (optionalMedewerker.isPresent()) {
            Medewerker medewerker = optionalMedewerker.get();
            String wachtwoord = medewerker.getWachtwoord();
            return wachtwoord;
        } else {
            return "onjuist";
        }
    }

    public void saveMedewerker( Medewerker medewerker){
        medewerkerRepository.save(medewerker);
    }

}
