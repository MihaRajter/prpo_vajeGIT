import javax.persistence.*;

@Entity(name = "uporabnikseznam")
@NamedQueries(value =
        {
                @NamedQuery(name = "Uporabnikseznam.getAll", query = "SELECT o FROM uporabnikseznam o")
        })
public class Uporabnikseznam {

    private boolean odkljukan;

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer id_ups;

    @ManyToOne
    @JoinColumn(name = "Uporabnik_id")
    private Uporabnik uporabnik;
    @ManyToOne
    @JoinColumn(name = "id_seznama")
    private Seznam seznam;

    //getter setter -.-----------

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