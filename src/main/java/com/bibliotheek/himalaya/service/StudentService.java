package com.bibliotheek.himalaya.service;

import com.bibliotheek.himalaya.model.Student;
import com.bibliotheek.himalaya.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(int id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public List<Student> getStudentLijst(){
        List<Student> studentLijst = studentRepository.findAll();
        return studentLijst;
    }
    public boolean isBestaandeStudent(int studentNr) {
        return studentRepository.findByStudentNr(studentNr) != null;
    }
    public boolean isBestaandStudent(int lidnummer) {
        return studentRepository.findByLidnummer(lidnummer) != null;
    }


    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentByLidnummer(int lidnummer) {
      return studentRepository.findByLidnummer(lidnummer);
    }
}
