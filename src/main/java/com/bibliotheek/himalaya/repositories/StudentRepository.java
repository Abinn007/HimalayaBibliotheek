package com.bibliotheek.himalaya.repositories;

import com.bibliotheek.himalaya.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value="select * from student  where student_nr = :studentNr", nativeQuery = true )
   Student findByStudentNr (@Param("studentNr") int studentNr);

    Student findByLidnummer(int lidNr);

}
