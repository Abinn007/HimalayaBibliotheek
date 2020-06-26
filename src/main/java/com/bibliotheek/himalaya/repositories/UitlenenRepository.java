package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.model.Student;
import com.bibliotheek.himalaya.model.Uitlenen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UitlenenRepository extends JpaRepository<Uitlenen, Integer> {

    @Query(value="SELECT * FROM uitlenen\n" +
            "    WHERE datum_terug_gebracht IS NULL\n" +
            "    AND boek_id = :boekID", nativeQuery = true )
    Uitlenen findByBoekId (@Param("boekID") int boekId);


    Uitlenen findByBoek(Boek boek);
}
