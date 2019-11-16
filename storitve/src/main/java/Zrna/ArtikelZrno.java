package Zrna;

import entities.Artikel;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ArtikelZrno {


    private Logger log = Logger.getLogger(ArtikelZrno.class.getName());

    private int idZrna;
    private String ime;
    private int st_nakupov;

    public ArtikelZrno{

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String st_nakupov() {
        return st_nakupov;
    }

    public void setNakupi(int nakupi) {
        this.st_nakupov = nakupi;
    }

    @PostConstruct
    private void init(){
        log.info("Inicializacija Zrna "+ArtikelZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+ArtikelZrno.class.getSimpleName());
    }

    public ArtikelZrno(int id, String ime, int nakupi ){
        this.idZrna = id;
        this.ime = ime;
        this.st_nakupov = nakupi;
    }

    public List<Artikel> pridobiArtikleCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Artikel> query = criteriaBuilder.createQuery(Artikel.class);
        Root<Artikel> from = query.from(Artikel.class);
        query.select(from);
        return em.createNamedQuery(query).getResultList();
    }

    @PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;

    public List<Artikel> getArtikli() {

        // implementacija
        return (List<Artikel>) em.createNamedQuery("entities.Artikel.getAll").getResultList();

    }

    public Artikel pridobiArtikel(int artikelID){
        Artikel artikel = em.find(Artikel.class, artikelID);
        return artikel;
    }

    @Transactional
    public Artikel dodajArtikel(Artikel artikel){
        if(artikel != null){
            em.persist(artikel);
        }
        return artikel;
    }

    @Transactional
    public Artikel posodobiArtikel(int artikelID, Artikel artikel){
        Artikel u = em.find(Artikel.class, artikelID);
        artikel.setArtikel_id(u.getArtikel_id());
        em.merge(artikel);
    }

    @Transactional
    public Integer odstraniArtikel(int artikelID){
        Artikel artikel = pridobiArtikel(artikelID);
        if(artikel != null){
            em.remove(artikel);
        }
        return artikelID;
    }



}
