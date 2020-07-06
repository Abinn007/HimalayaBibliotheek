package com.bibliotheek.himalaya.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Autor implements Comparable<Autor> {
    @Id
    @GeneratedValue
    private int autor_id;

    private String naam;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Boek> boeken;

    public Autor(){
        this("");
    }

    public Autor( String naam) {
        this.naam = naam;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int id) {
        this.autor_id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void toevoegenBoek(Boek boek){
        boeken.add(boek);
    }

    @Override
    public String toString() {
        return autor_id + " " + naam + " " + boeken;
    }


    @Override
    public int compareTo(Autor o) {
        return this.naam.compareTo(o.naam);
    }

}
