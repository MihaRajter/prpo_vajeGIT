package Uprava;

public class ArtikelDto {

    private Integer artikel_id;
    private String ime;
    private Integer st_nakupov;


    public Integer getArtikel_id() {
        return artikel_id;
    }

    public void setArtikel_id(Integer artikel_id) {
        this.artikel_id = artikel_id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getSt_nakupov() {
        return st_nakupov;
    }

    public void setSt_nakupov(Integer st_nakupov) {
        this.st_nakupov = st_nakupov;
    }
}
