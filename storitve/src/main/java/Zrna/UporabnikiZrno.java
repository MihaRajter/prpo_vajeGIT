package Zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import entities.Uporabnik;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UporabnikiZrno{

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());

    private Integer idZrna;
    private String ime;
    private String priimek;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    @PostConstruct
    private void init(){
        log.info("Inicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }


@PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;


    //??
    @Context
    protected UriInfo uriInfo;


//--


    public List<Uporabnik> getUporabniki(QueryParameters query) {

        // implementacija
        //return (List<Uporabnik>) em.createNamedQuery("entities.Uporabnik.getAll").getResultList();
        return JPAUtils.queryEntities(em,Uporabnik.class,query);
    }
    public Long getUporabnikiCount(QueryParameters query){
        return JPAUtils.queryEntitiesCount(em,Uporabnik.class,query);
    }

    public Uporabnik pridobiUporabnika(int uporabnikID){
        Uporabnik uporabnik = em.find(Uporabnik.class, uporabnikID);
        return uporabnik;
    }
    public Uporabnik dodajUporabnika(Uporabnik uporabnik){
        if(uporabnik != null){
            em.getTransaction().begin();
            em.persist(uporabnik);
            em.getTransaction().commit();
        }
        return uporabnik;
    }

    public Uporabnik posodobiUporabnika(int UporabnikID, Uporabnik uporabnik){
        Uporabnik u = em.find(Uporabnik.class, UporabnikID);
        uporabnik.setId(u.getId());
        em.merge(uporabnik);

        return u;

    }

    public Integer odstraniUporabnika(int UporabnikID){
        Uporabnik uporabnik = pridobiUporabnika(UporabnikID);
        if(uporabnik != null){
            em.remove(uporabnik);
        }
        return UporabnikID;
    }


}
