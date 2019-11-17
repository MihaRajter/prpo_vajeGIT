package Uprava;

import entities.Artikel;
import entities.Seznam;

public class SeznamartikelDto {

    private Integer id_sza;
    private boolean read;
    private boolean write;
    private Artikel artikel;
    private Seznam seznam;

    public Integer getId_sza() {
        return id_sza;
    }

    public void setId_sza(Integer id_sza) {
        this.id_sza = id_sza;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Seznam getSeznam() {
        return seznam;
    }

    public void setSeznam(Seznam seznam) {
        this.seznam = seznam;
    }
}
