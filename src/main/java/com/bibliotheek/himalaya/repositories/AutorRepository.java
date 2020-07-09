package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Autor findByNaam(String naam);

}
