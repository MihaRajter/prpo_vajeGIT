package Uprava;

public class UporabnikiDto {

    private Integer Uporabnik_id;
    private String ime;
    private String priimek;

    public Integer getUporabnik_id() {
        return Uporabnik_id;
    }

    public void setUporabnik_id(Integer uporabnik_id) {
        Uporabnik_id = uporabnik_id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }
}
