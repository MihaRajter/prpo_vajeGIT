package Uprava;

import entities.Seznam;
import entities.Uporabnik;
import entities.Uporabnikseznam;

public class DeloUporabnikDto {

    //dodajSeznamUporabniku

    Uporabnik uporabnik;

    String seznam_naziv;

    Boolean use_odkljukan;

    //-dodajUporabnikSeznamu

    Seznam seznam;

    String uporabnik_ime;

    String uporabnik_priimek;

    public DeloUporabnikDto(boolean use_odkljukan,Uporabnik u, Seznam s)
    {
        this.uporabnik=u;
        this.seznam=s;
        this.seznam_naziv=s.getNaziv();
        this.uporabnik_ime=u.getIme();
        this.uporabnik_priimek=u.getPriimek();
        this.use_odkljukan=use_odkljukan;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public String getSeznam_naziv() {
        return seznam_naziv;
    }

    public void setSeznam_naziv(String seznam_naziv) {
        this.seznam_naziv = seznam_naziv;
    }

    public Boolean getUse_odkljukan() {
        return use_odkljukan;
    }

    public void setUse_odkljukan(Boolean use_odkljukan) {
        this.use_odkljukan = use_odkljukan;
    }

    public Seznam getSeznam() {
        return seznam;
    }

    public void setSeznam(Seznam seznam) {
        this.seznam = seznam;
    }

    public String getUporabnik_ime() {
        return uporabnik_ime;
    }

    public void setUporabnik_ime(String uporabnik_ime) {
        this.uporabnik_ime = uporabnik_ime;
    }

    public String getUporabnik_priimek() {
        return uporabnik_priimek;
    }

    public void setUporabnik_priimek(String uporabnik_priimek) {
        this.uporabnik_priimek = uporabnik_priimek;
    }
}
