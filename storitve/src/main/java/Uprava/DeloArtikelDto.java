package Uprava;

import entities.Artikel;
import entities.Seznam;

public class DeloArtikelDto {

    //dodajArtikelSeznamu

    Seznam seznam;

    Integer artikel_steviloNaKupov;

    Boolean sza_read;

    Boolean sza_write;

    //dodajSeznamArtiklu

    Artikel artikel;

    String seznam_naziv;

    public Seznam getSeznam() {
        return seznam;
    }

    public void setSeznam(Seznam seznam) {
        this.seznam = seznam;
    }

    public Integer getArtikel_steviloNaKupov() {
        return artikel_steviloNaKupov;
    }

    public void setArtikel_steviloNaKupov(Integer artikel_steviloNaKupov) {
        this.artikel_steviloNaKupov = artikel_steviloNaKupov;
    }

    public Boolean getSza_read() {
        return sza_read;
    }

    public void setSza_read(Boolean sza_read) {
        this.sza_read = sza_read;
    }

    public Boolean getSza_write() {
        return sza_write;
    }

    public void setSza_write(Boolean sza_write) {
        this.sza_write = sza_write;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public String getSeznam_naziv() {
        return seznam_naziv;
    }

    public void setSeznam_naziv(String seznam_naziv) {
        this.seznam_naziv = seznam_naziv;
    }
}
