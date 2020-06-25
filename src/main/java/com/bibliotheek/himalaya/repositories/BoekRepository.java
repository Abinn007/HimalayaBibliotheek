package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Medewerker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoekRepository extends JpaRepository<Boek, Integer> {

    Boek findBoekByIsbn(int isbn);

    @Query(value = "SELECT * FROM Boek", nativeQuery = true)
    List<Boek> boekenLijst();

    void removeBoekByIsbn(int isbn);





}
