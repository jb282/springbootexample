package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Beitrag {

    @Id
    @GeneratedValue
    private int id;
    private String landName;
    private String produktName;

    private String beschreibung;

    private long mitbringerId;
    @Size(max = 30000)
    private String pic = "https://www.maria-woerth.info/wp-content/uploads/2016/05/kein-bild.png";

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




    public long getMitbringerId() {
        return mitbringerId;
    }

    public void setMitbringerId(long mitbringerId) {
        this.mitbringerId = mitbringerId;
    }

    public Beitrag() {
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Beitrag(String landName, String produktName, String beschreibung, int mitbringerId) {
        this.landName = landName;
        this.produktName = produktName;
        this.beschreibung = beschreibung;
        this.mitbringerId = mitbringerId;
    }
}
