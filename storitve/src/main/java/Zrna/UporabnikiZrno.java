package Zrna;

import entities.*;
import entities.Uporabnik;
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
        return (List<Uporabnik>) em.createNamedQuery("entities.Uporabnik.getAll").getResultList();

    }
}
