package com.bibliotheek.himalaya.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Uitlenen")
public class Uitlenen {
    @Id
    @GeneratedValue
    private int id;
    private String datumUitlening;
    private String datumTerugGebracht;
    private String datumMaxUitlenen;

    @ManyToOne
    private Boek boek;
    @ManyToOne
    private Student student;

    public Uitlenen(){
        this("", "","",null,null);
    }

    public Uitlenen(String datumUitlening, String datumTerugGebracht, String datumMaxUitlenen, Boek boek, Student student) {
        this.datumUitlening = datumUitlening;
        this.datumTerugGebracht = datumTerugGebracht;
        this.datumMaxUitlenen = datumMaxUitlenen;
        this.boek = boek;
        this.student = student;
    }

    public String getDatumUitlening() {
        return datumUitlening;
    }

    public void setDatumUitlening(String datumUitlening) {
        this.datumUitlening = datumUitlening;
    }

    public String getDatumTerugGebracht() {
        return datumTerugGebracht;
    }

    public void setDatumTerugGebracht(String datumTerugGebracht) {
        this.datumTerugGebracht = datumTerugGebracht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatumMaxUitlenen() {
        return datumMaxUitlenen;
    }

    public void setDatumMaxUitlenen(String datumMaxUitlenen) {
        this.datumMaxUitlenen = datumMaxUitlenen;
    }

    public Boek getBoek() {
        return boek;
    }

    public void setBoek(Boek boek) {
        this.boek = boek;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Uitlenen{" +
                "id=" + id +
                ", datumUitlening='" + datumUitlening + '\'' +
                ", datumTerugGebracht='" + datumTerugGebracht + '\'' +
                ", datumMaxUitlenen='" + datumMaxUitlenen + '\'' +
                ", boek=" + boek +
                ", student=" + student +
                '}';
    }
}
