package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.repositories.BoekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoekService {
    @Autowired
    private final BoekRepository boekRepository;

    public BoekService(BoekRepository boekRepository) {
        this.boekRepository = boekRepository;
    }

    public Boek getBoekByIsdn(int isbn){
        return boekRepository.findBoekByIsbn(isbn);
    }

    public boolean isValidIsdn(int isbn) {
        return boekRepository.findBoekByIsbn(isbn) != null;
    }

    public void verwijderBoekById(int isbn){
        boekRepository.removeBoekByIsbn(isbn);
    }

    public void saveBoek(Boek boek) {
        boekRepository.save(boek);
    }

}
