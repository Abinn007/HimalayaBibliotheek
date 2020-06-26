package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Uitlenen;
import com.bibliotheek.himalaya.repositories.UitlenenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
public class UitlenenService {

    private static final int MAX_UITLENEN_DATUM = 15;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UitlenenRepository uitlenenRepository;

    @Autowired
    private BoekService boekService;

    public void save(Uitlenen uitlenen) {
        uitlenenRepository.save(uitlenen);
    }

    public List<Uitlenen> getAllUitlenen() {
        return uitlenenRepository.findAll();
    }

    @Transactional
    public void terugbrengenBoek(Uitlenen uitlenen) {
        Boek boek = boekService.getBoekByIsbn(uitlenen.getBoek().getIsbn());
        boek.setGeleend(false);
        save(uitlenen);
        em.persist(uitlenen);
    }

    public Uitlenen findByBoekId(int boekId) {
        List<Uitlenen> uitlenenList = uitlenenRepository.findByBoekId(boekId);
        Uitlenen uitlenen = null;
        for (Uitlenen value : uitlenenList) {
            if (value.getDatumTerugGebracht() == null) {
                uitlenen = value;
            }

        }
        return uitlenen;
    }


    @Transactional
    public String verlengenBoek(Uitlenen uitlenen) {
        LocalDate parsedDatum = LocalDate.parse(uitlenen.getDatumMaxUitlenen());
        String nieuweMaxLeningDatum = (parsedDatum.plusDays(MAX_UITLENEN_DATUM)).toString();
        uitlenen.setDatumMaxUitlenen(nieuweMaxLeningDatum);
        save(uitlenen);
        em.persist(uitlenen);
        return nieuweMaxLeningDatum;
    }


}
