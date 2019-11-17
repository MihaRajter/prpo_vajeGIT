package Uprava;

import entities.Seznam;
import entities.Uporabnik;

public class UporabnikiseznamDto {

    private boolean odkljukan;
    private Integer id_ups;
    private Uporabnik uporabnik;
    private Seznam seznam;

    public UporabnikiseznamDto(){
     }
    public UporabnikiseznamDto(boolean odkljukan,Uporabnik u,Seznam s){
        this.odkljukan = odkljukan;
        this.uporabnik = u;
        this.seznam = s;
    }

    public boolean isOdkljukan() {
        return odkljukan;
    }

    public void setOdkljukan(boolean odkljukan) {
        this.odkljukan = odkljukan;
    }

    public Integer getId_ups() {
        return id_ups;
    }

    public void setId_ups(Integer id_ups) {
        this.id_ups = id_ups;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Seznam getSeznam() {
        return seznam;
    }

    public void setSeznam(Seznam seznam) {
        this.seznam = seznam;
    }
}
