package com.bibliotheek.himalaya.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Boek")
public class Boek {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String isbn;
    private boolean geleend;

    @OneToMany(mappedBy = "boek", cascade = {CascadeType.ALL})
    private List<Uitlenen> uitlenenList;

    @ManyToMany(mappedBy= "boeken")
    private List<Autor> autors;

    public Boek(){
        this("",null);
    }

    public Boek(String title, String isbn) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isGeleend() {
        return geleend;
    }

    public void setGeleend(boolean geleend) {
        this.geleend = geleend;
    }
}
