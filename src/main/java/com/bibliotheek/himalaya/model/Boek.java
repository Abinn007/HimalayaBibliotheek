package com.bibliotheek.himalaya.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Boek {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int isbn;
    private boolean geleend;

    @OneToMany
    private List<Uitlenen> uitlenenList;

    @ManyToMany(mappedBy= "boeken")
    private List<Autor> autors;

    public Boek(){
        this("",0);
    }

    public Boek(String title, int isbn) {
        this.title = title;
        this.isbn = isbn;
        this.geleend = false;
        this.autors = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isdn) {
        this.isbn = isdn;
    }

    public boolean isGeleend() {
        return geleend;
    }

    public void setGeleend(boolean geleend) {
        this.geleend = geleend;
    }
}
