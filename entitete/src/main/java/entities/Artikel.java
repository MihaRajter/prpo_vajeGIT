package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "artikel")
@NamedQueries(value =
        {
                @NamedQuery(name = "entities.Artikel.getAll", query = "SELECT o FROM artikel o"),
                @NamedQuery(name = "entities.Artikel.getoneId", query = "SELECT o FROM artikel o WHERE o.artikel_id = :artikel_id"),
                @NamedQuery(name = "entities.Artikel.getoneIme", query = "SELECT o FROM artikel o WHERE o.ime = :ime")
        })
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artikel_id;

    @Column(name = "ime")
    private String ime;
    
    @Column(name = "st_nakupov")
    private Integer st_nakupov;

    @OneToMany(mappedBy="artikel",cascade = CascadeType.PERSIST)
    private List<Seznamartikel> seznamartikelList = new ArrayList<>();

    public Artikel()
    {

    }

    //---------------------------------  getter in setter metode

    public Integer getArtikel_id() {
        return artikel_id;
    }

    public void setArtikel_id(Integer artikel_id) {
        artikel_id = artikel_id;
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