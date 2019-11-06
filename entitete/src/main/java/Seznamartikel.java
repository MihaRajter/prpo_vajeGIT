import javax.persistence.*;

@Entity(name = "seznamartikel")
@NamedQueries(value =
        {
                @NamedQuery(name = "Seznamartikel.getAll", query = "SELECT o FROM seznamartikel o")
        })
public class Seznamartikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private boolean read;
    private boolean write;

    @ManyToOne
    private Artikel artikel_id;
    @ManyToOne
    private Seznam seznam_id;

    // getter in setter metode -------------------


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

    public Artikel getArtikel_id() {
        return artikel_id;
    }

    public void setArtikel_id(Artikel artikel_id) {
        this.artikel_id = artikel_id;
    }

    public Seznam getSeznam_id() {
        return seznam_id;
    }

    public void setSeznam_id(Seznam seznam_id) {
        this.seznam_id = seznam_id;
    }
}