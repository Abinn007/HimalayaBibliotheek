package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Medewerker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface BoekRepository extends JpaRepository<Boek, Integer> {

    Boek findBoekByIsbn(String isbn);

    @Query(value = "SELECT * FROM Boek WHERE geleend = true", nativeQuery = true)
    List<Boek> geleendBoekenLijst();

    @Query(value = "SELECT * FROM Boek WHERE geleend = false", nativeQuery = true)
    List<Boek> nietGeleendBoekenLijst();

    void removeBoekByIsbn(int isbn);

    Boek findBoekByIsbnAndGeleendIsFalse(String isbn);

    Boek findBoekByIsbnAndGeleendIsTrue(String isbn);





}
