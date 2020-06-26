package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Uitlenen;
import com.bibliotheek.himalaya.repositories.BoekRepository;
import com.bibliotheek.himalaya.repositories.UitlenenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UitlenenService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UitlenenRepository uitlenenRepository;

    @Autowired
    private BoekService boekService;

    public void save(Uitlenen uitlenen) {
        uitlenenRepository.save(uitlenen);
    }

    public List<Uitlenen> getAllUitlenen(){
        return uitlenenRepository.findAll();
    }
    public Uitlenen findByBoek(Boek boek){
        return uitlenenRepository.findByBoek(boek);
    }

    public Uitlenen findByBoekId(int boekId){
       return uitlenenRepository.findByBoekId(boekId);
    }

    @Transactional
    public void terugbrengenBoek(Uitlenen uitlenen) {
        Boek boek = boekService.getBoekByIsdn(uitlenen.getBoek().getIsbn());
        boek.setGeleend(false);
        save(uitlenen);
        em.persist(uitlenen);
    }

}
