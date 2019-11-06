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
    @ManyToOne
    private Uporabnik uporabnik_id;
    @ManyToOne
    private Seznam seznam_id;

    //getter setter -.-----------


    public boolean isOdkljukan() {
        return odkljukan;
    }

    public void setOdkljukan(boolean odkljukan) {
        this.odkljukan = odkljukan;
    }

    public Uporabnik getUporabnik_id() {
        return uporabnik_id;
    }

    public void setUporabnik_id(Uporabnik uporabnik_id) {
        this.uporabnik_id = uporabnik_id;
    }

    public Seznam getSeznam_id() {
        return seznam_id;
    }

    public void setSeznam_id(Seznam seznam_id) {
        this.seznam_id = seznam_id;
    }
}