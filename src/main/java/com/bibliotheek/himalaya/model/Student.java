package com.bibliotheek.himalaya.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    private int lidnummer;

    private int student_nr;
    private String naam;
    private String geboortedatum;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    List<Uitlenen> uitlenenList;

    //Constructors
    public Student() {
        this(0,null,null);
    }

    public Student(int student_nr, String naam, String geboortedatum) {
        this.student_nr = student_nr;
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    //getters & setters

    public int getLidnummer() {
        return lidnummer;
    }

    public void setLidnummer(int lidnummer) {
        this.lidnummer = lidnummer;
    }

    public int getStudent_nr() {
        return student_nr;
    }

    public void setStudent_nr(int student_nr) {
        this.student_nr = student_nr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString(){
        return ("Lidnummer: "+ lidnummer +"\n" + "Studentnummer: "+student_nr +"\n" +"Studentnaam: "+naam);
    }
}
