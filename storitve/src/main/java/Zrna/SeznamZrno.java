package Zrna;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import entities.Seznam;
import entities.Uporabnik;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;


@ApplicationScoped
public class SeznamZrno {


    private Logger log = Logger.getLogger(SeznamZrno.class.getName());

    private Client httpClient;


    private Integer id_seznama;

    private String naziv;

    public int getId_seznama() {
        return id_seznama;
    }

    public void setId_seznama(int id_seznama) {
        this.id_seznama = id_seznama;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @PostConstruct
    private void init(){

        httpClient = ClientBuilder.newClient();
        log.info("Inicializacija Zrna "+SeznamZrno.class.getSimpleName());
    }


    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+SeznamZrno.class.getSimpleName());
    }


    @PersistenceContext(unitName = "nakupovalni-seznami-jpa")
    private EntityManager em;


    @Context
    protected UriInfo uriInfo;

    public List<Seznam> getSeznami(QueryParameters query) {

        // implementacija
        //return (List<Seznam>) em.createNamedQuery("entities.Seznam.getAll").getResultList();
        return JPAUtils.queryEntities(em, Seznam.class,query);
    }

    public Long getSeznamiCount(QueryParameters query){
        return JPAUtils.queryEntitiesCount(em,Seznam.class,query);
    }

    public Seznam dodajSeznam(Seznam seznam){
        if(seznam != null){
            em.persist(seznam);
        }
        return seznam;
    }



    public Seznam posodobiSeznam(int id_seznama, Seznam seznam){
        Seznam u = em.find(Seznam.class, id_seznama);
        seznam.setId_seznama(u.getId_seznama());
        em.merge(seznam);
        return u;
    }

    public Seznam pridobiSeznam(int seznamID){
        Seznam seznam = em.find(Seznam.class, seznamID);
        return seznam;
    }

    public Integer odstraniSeznam(int id_seznama){
        Seznam seznam = pridobiSeznam(id_seznama);
        if(seznam != null){
            em.remove(seznam);
        }
        return id_seznama;
    }


    public Object getZanimivost() {
        int number =(int) ( Math.random()*100);
        String url = "https://numbersapi.p.rapidapi.com/"+1729+"/math";

        try{


            return httpClient
                    .target(url)
                    .request()
                    .header("X-RapidAPI-Key", "ea91e01f3emsha873adf46c87ab8p10d4c8jsn311ba5b90034")
                    .get(String.class);
        } catch (WebApplicationException | ProcessingException e){
            throw new InternalServerErrorException(e);
        }

    }
}
