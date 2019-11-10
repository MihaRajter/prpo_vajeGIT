import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class UporabnikiZrno {

    @PersistenceContext(unitName = "lokacijski-opomniki-jpa")
    private EntityManager em;

    public List<Uporabnik> getUporabniki() {

        // implementacija
        List<Uporabnik> list = em.createNamedQuery("Uporabnik.getAll").getResultList();
        return list;

    }
}
