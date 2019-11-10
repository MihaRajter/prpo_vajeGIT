import javax.persistence.*;

@Entity(name = "artikel")
@NamedQueries(value =
        {
                @NamedQuery(name = "Artikel.getAll", query = "SELECT o FROM artikel o"),
                @NamedQuery(name = "Artikel.getoneId", query = "SELECT o FROM artikel o WHERE o.Artikel_id = :Artikel_id"),
                @NamedQuery(name = "Artikel.getoneIme", query = "SELECT o FROM artikel o WHERE o.ime = :ime")
        })
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Artikel_id;

    @Column(name = "ime")
    private String ime;
    
    @Column(name = "st_nakupov")
    private Integer st_nakupov;

    //---------------------------------  getter in setter metode

    public Integer getArtikel_id() {
        return Artikel_id;
    }

    public void setArtikel_id(Integer artikel_id) {
        Artikel_id = artikel_id;
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