package com.bibliotheek.himalaya.utilities;

import com.bibliotheek.himalaya.model.Medewerker;

public class MedewerkerLoginBackingBean {
    private String voorletters;
    private String achternaam;
    private String gebruikersnaam;
    private String wachtwoord;

    public MedewerkerLoginBackingBean(){
        this("","","", "");
    }

    public MedewerkerLoginBackingBean(String voorletters, String achternaam, String gebruikersnaam, String wachtwoord) {
        this.voorletters = voorletters;
        this.achternaam = achternaam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Medewerker getMedewerker(){
        Medewerker medewerker = new Medewerker(gebruikersnaam,wachtwoord);
        return medewerker;
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
