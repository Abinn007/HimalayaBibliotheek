package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Boek;
import com.bibliotheek.himalaya.model.Medewerker;
import com.bibliotheek.himalaya.model.Uitlenen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UitlenenRepository extends JpaRepository<Uitlenen, Integer> {


}
