package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "seznam")
@NamedQueries(value =
        {
                @NamedQuery(name = "entities.Seznam.getAll", query = "SELECT o FROM seznam o"),
                //@NamedQuery(name = "entities.Seznam.getAll", query = "SELECT s FROM seznam s, seznamartikel sa, artikel a WHERE s.id_seznama=sa.id_seznama AND sa.artikel_id=:artikel_id"),
                @NamedQuery(name = "entities.Seznam.getoneId", query = "SELECT o FROM seznam o WHERE o.id_seznama = :id_seznama"),
        })
public class Seznam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_seznama;
    // getter in setter metode

    @Column(name = "naziv")
    private String naziv;

    @JsonbTransient
    @OneToMany(mappedBy="seznam",cascade = CascadeType.PERSIST)
    private List<Seznamartikel> seznamartikelList = new ArrayList<>();

    @JsonbTransient
    @OneToMany(mappedBy="seznam",cascade = CascadeType.PERSIST)
    private List<Uporabnikseznam> uporabnikseznamList = new ArrayList<>();

    public Seznam(){

    }

    public Seznam(String naziv){
        this.naziv = naziv;
    }

    //------------------ getter setter


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId_seznama() {
        return id_seznama;
    }

    public void setId_seznama(Integer id_seznama) {
        this.id_seznama = id_seznama;
    }
}