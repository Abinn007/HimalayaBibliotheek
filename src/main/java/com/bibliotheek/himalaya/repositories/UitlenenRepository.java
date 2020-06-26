package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.model.Student;
import com.bibliotheek.himalaya.model.Uitlenen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UitlenenRepository extends JpaRepository<Uitlenen, Integer> {

    @Query(value="SELECT * FROM uitlenen\n" +
            "    WHERE boek_id = :boekID \n", nativeQuery = true )
    List<Uitlenen> findByBoekId (@Param("boekID") int boekID);


    Uitlenen findByBoek(Boek boek);
}
