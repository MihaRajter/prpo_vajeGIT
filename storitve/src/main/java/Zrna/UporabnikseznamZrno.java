package Zrna;

import entities.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UporabnikseznamZrno {

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());

    private boolean odkljukan;
    private Integer id_ups;
    private Uporabnik uporabnik;
    private Seznam seznam;

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

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

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @PostConstruct
    private void init(){
        log.info("Inicializacija Zrna "+UporabnikseznamZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+UporabnikseznamZrno.class.getSimpleName());
    }


    @PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;

    public List<Uporabnikseznam> getUps() {

        // implementacija
        return (List<Uporabnikseznam>) em.createNamedQuery("entities.Uporabnikseznam.getAll").getResultList();

    }

    public Uporabnikseznam pridobiUps(int id_ups){
        Uporabnikseznam ups = em.find(Uporabnikseznam.class, id_ups);
        return ups;
    }
    public Uporabnikseznam dodajUps(Uporabnikseznam ups){
        if(ups != null){
            em.getTransaction().begin();
            em.persist(ups);
            em.getTransaction().commit();
        }
        return ups;
    }

    public void posodobiUps(int id_ups, Uporabnikseznam ups){
        Uporabnikseznam u = em.find(Uporabnikseznam.class, id_ups);
        ups.setId_ups(u.getId_ups());
        em.merge(ups);

    }

    public Integer odstraniUps(int id_ups){
        Uporabnikseznam ups = pridobiUps(id_ups);
        if(ups != null){
            em.remove(ups);
        }
        return id_ups;
    }




}
