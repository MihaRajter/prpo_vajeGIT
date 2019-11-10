package entities;

import javax.persistence.*;

@Entity(name = "seznamartikel")
@NamedQueries(value =
        {
                @NamedQuery(name = "entities.Seznamartikel.getAll", query = "SELECT o FROM seznamartikel o")
        })
public class Seznamartikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sza;

    @Column(name = "read")
    private boolean read;

    @Column(name = "write")
    private boolean write;

    @ManyToOne
    @JoinColumn(name = "artikel_id")
    private Artikel artikel;
    @ManyToOne
    @JoinColumn(name = "id_seznama")
    private Seznam seznam;

    // getter in setter metode -------------------


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