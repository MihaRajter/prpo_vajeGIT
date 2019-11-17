package Zrna;

import entities.Artikel;
import entities.Seznam;
import entities.Seznamartikel;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class SeznamartikelZrno {

    private Logger log = Logger.getLogger(SeznamartikelZrno.class.getName());

    private Integer id_sza;
    private boolean read;
    private boolean write;
    private Artikel artikel;
    private Seznam seznam;

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

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @PostConstruct
    private void init(){
        log.info("Inicializacija Zrna "+SeznamartikelZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+SeznamartikelZrno.class.getSimpleName());
    }


    @PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;

    public List<Seznamartikel> getSza() {

        // implementacija
        return (List<Seznamartikel>) em.createNamedQuery("entities.Seznamartikel.getAll").getResultList();

    }

    public Seznamartikel pridobiSza(int id_sza){
        Seznamartikel sza = em.find(Seznamartikel.class, id_sza);
        return sza;
    }
    public Seznamartikel dodajSza(Seznamartikel sza){
        if(sza != null){
            em.getTransaction().begin();
            em.persist(sza);
            em.getTransaction().commit();
        }
        return sza;
    }

    public void posodobiSza(int id_sza, Seznamartikel sza){
        Seznamartikel s = em.find(Seznamartikel.class, id_sza);
        sza.setId_sza(s.getId_sza());
        em.merge(sza);

    }

    public Integer odstraniSza(int id_sza){
        Seznamartikel sza = pridobiSza(id_sza);
        if(sza != null){
            em.remove(sza);
        }
        return id_sza;
    }



}
