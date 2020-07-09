package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Autor;
import com.bibliotheek.himalaya.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void saveAutor(Autor autor){
        autorRepository.save(autor);
    }

    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    public boolean isBestaandAutor(String naam){
        return autorRepository.findByNaam(naam) != null;
    }
}
