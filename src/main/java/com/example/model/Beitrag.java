package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beitrag {

    @Id
    @GeneratedValue
    private int id;
    private String landName;
    private String produktName;
    private String beschreibung;
    private  String kontakt;
    private long mitbringerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public String getProduktName() {
        return produktName;
    }

    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }


    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }





 public long getMitbringerId() {
        return mitbringerId;
    }

    public void setMitbringerId(long mitbringerId) {
        this.mitbringerId = mitbringerId;
    }

    public Beitrag() {
    }

    public Beitrag(String landName, String produktName, int mitbringerId) {
        this.landName = landName;
        this.produktName = produktName;
        this.mitbringerId = mitbringerId;
        this.beschreibung = beschreibung;
        this.kontakt = kontakt;
 }
}
