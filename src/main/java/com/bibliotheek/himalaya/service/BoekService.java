package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.repositories.BoekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoekService {
    @Autowired
    private final BoekRepository boekRepository;

    public BoekService(BoekRepository boekRepository) {
        this.boekRepository = boekRepository;
    }

    public Boek getBoekByIsbn(String isbn){
        return boekRepository.findBoekByIsbn(isbn);
    }

    public boolean isBestaandIsbn(String isbn) {
        return boekRepository.findBoekByIsbn(isbn) != null;
    }

    public void verwijderBoekById(int isbn){
        boekRepository.removeBoekByIsbn(isbn);
    }

    public void saveBoek(Boek boek) {
        boekRepository.save(boek);
    }

    public List<Boek> getAllBoeken() {
        return boekRepository.findAll();
    }

    public  List<Boek> geleendBoekenLijst() {
        return boekRepository.geleendBoekenLijst();
    }
    public  List<Boek> nietGeleendBoekenLijst() {
        return boekRepository.nietGeleendBoekenLijst();
    }

    public boolean isBeschikbaar(String isbn) {
        return boekRepository.findBoekByIsbnAndGeleendIsFalse(isbn) != null;
    }

    public boolean isUitgeleend(String isbn) {
        return boekRepository.findBoekByIsbnAndGeleendIsTrue(isbn) != null;
    }
}
