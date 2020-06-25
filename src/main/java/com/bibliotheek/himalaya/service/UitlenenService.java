package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Uitlenen;
import com.bibliotheek.himalaya.repositories.BoekRepository;
import com.bibliotheek.himalaya.repositories.UitlenenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UitlenenService {
    @Autowired
    private UitlenenRepository uitlenenRepository;

    public void save(Uitlenen uitlenen) {
        uitlenenRepository.save(uitlenen);
    }

//    @Transactional
//    public void maakGeldOver(Uitlenen uitlenen) {
////      session.beginTransaction();
////      transaction.begin();
//
//        Rekening rekeningCredit = rekeningRepository.findByRekeningnummer(transactie.getRekeningNrCredit());
//        rekeningCredit.setSaldo(rekeningCredit.getSaldo() + transactie.getTransactieBedrag());
//        Rekening rekeningDebet = rekeningRepository.findByRekeningnummer(transactie.getRekeningNrDebet());
//        rekeningDebet.setSaldo(rekeningDebet.getSaldo() - transactie.getTransactieBedrag());
//        transactie.setDatumTransactie(date);
//        saveTransactie(transactie);
//        em.persist(transactie);
//    }
}
