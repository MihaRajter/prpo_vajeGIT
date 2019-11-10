package entities;

import javax.persistence.*;

@Entity(name = "uporabnik")
@NamedQueries(value =
        {
                @NamedQuery(name = "entities.Uporabnik.getAll", query = "SELECT o FROM uporabnik o")
        })
public class Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Uporabnik_id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "priimek")
    private String priimek;

    //getter setter ---------------------------

    public Integer getId() {
        return Uporabnik_id;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setId(Integer id) {
        this.Uporabnik_id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }
}