package Zrna;

import entities.Seznam;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

public class SeznamZrno {


    private Logger log = Logger.getLogger(SeznamZrno.class.getName());

    private int id_seznama;

    public int getId_seznama() {
        return id_seznama;
    }

    public void setId_seznama(int id_seznama) {
        this.id_seznama = id_seznama;
    }

    @PostConstruct
    private void init(){
        log.info("Inicializacija Zrna "+SeznamZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+SeznamZrno.class.getSimpleName());
    }

    public SeznamZrno(int id){
        this.id_seznama = id;

    }
/*
    public List<Seznam> pridobiSeznamCriteriaAPI(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Seznam> query = criteriaBuilder.createQuery(Seznam.class);
        Root<Seznam> from = query.from(Seznam.class);
        query.select(from);
        return em.createNamedQuery(query).getResultList();
    }
*/
    @PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;

    public List<Seznam> getSeznami() {

        // implementacija
        return (List<Seznam>) em.createNamedQuery("entities.Seznam.getAll").getResultList();

    }

    public Seznam pridobiSeznam(int id_seznama){
        Seznam seznam = em.find(Seznam.class, id_seznama);
        return seznam;
    }

    @Transactional
    public Seznam dodajSeznam(Seznam seznam){
        if(seznam != null){
            em.persist(seznam);
        }
        return seznam;
    }

    @Transactional
    public void posodobiSeznam(int id_seznama, Seznam seznam){
        Seznam u = em.find(Seznam.class, id_seznama);
        seznam.setId_seznama(u.getId_seznama());
        em.merge(seznam);

    }

    @Transactional
    public Integer odstraniSeznam(int id_seznama){
        Seznam seznam = pridobiSeznam(id_seznama);
        if(seznam != null){
            em.remove(seznam);
        }
        return id_seznama;
    }



}
