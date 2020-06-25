package com.bibliotheek.himalaya.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medewerker {
    @Id
    @GeneratedValue
    private int medewerker_id;

    private String voorletters;
    private String achternaam;
    private String gebruikersnaam;
    private String wachtwoord;


    public Medewerker() {
        this("", "");
    }

    public Medewerker(String voorletters, String achternaam, String gebruikersnaam, String wachtwoord) {
        this.voorletters = voorletters;
        this.achternaam = achternaam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Medewerker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public int getMedewerker_id() {
        return medewerker_id;
    }

    public void setMedewerker_id(int medewerker_id) {
        this.medewerker_id = medewerker_id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
