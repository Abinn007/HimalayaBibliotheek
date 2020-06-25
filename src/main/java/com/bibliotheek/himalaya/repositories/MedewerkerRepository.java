package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Medewerker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedewerkerRepository extends JpaRepository<Medewerker, Integer> {

    public Medewerker findMedewerkerByGebruikersnaam(String gebruikersnaam);
}
