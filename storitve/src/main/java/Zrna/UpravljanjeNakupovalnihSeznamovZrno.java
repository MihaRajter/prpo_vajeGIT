package Zrna;

import Uprava.DeloUporabnikDto;
import Uprava.NakupovalniSeznamDto;
import Uprava.SeznamartikelDto;
import Uprava.UporabnikiseznamDto;
import entities.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class UpravljanjeNakupovalnihSeznamovZrno {

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());

    @Inject
    private UporabnikiZrno uporabnikiZrno;
    @Inject
    private SeznamZrno seznamZrno;
    @Inject
    private ArtikelZrno artikelZrno;
    @Inject
    private UporabnikseznamZrno uporabnikseznamZrno;
    @Inject
    private SeznamartikelZrno seznamartikelZrno;


    @PostConstruct
    private void Init(){
            log.info("Inicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }
    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }

    public Uporabnikseznam dodajUporabnikuSeznam(DeloUporabnikDto use){

        //ena
        Uporabnik uporabnik=use.getUporabnik();

        Seznam seznam=seznamZrno.pridobiSeznam(use.getSeznam().getId_seznama());


        Uporabnikseznam novUps = new Uporabnikseznam();
        uporabnikiZrno.dodajUporabnika(uporabnik);

        novUps.setOdkljukan(use.getUse_odkljukan());
        novUps.setUporabnik(uporabnik);
        //novUps.setSeznam(seznam);

        return uporabnikseznamZrno.dodajUps(novUps);
    }

    public Uporabnikseznam dodajSeznamUporabniku(DeloUporabnikDto use){

        //ena
        Uporabnik uporabnik=uporabnikiZrno.pridobiUporabnika(use.getUporabnik().getId());
        Seznam seznam=use.getSeznam();

        Uporabnikseznam novUps = new Uporabnikseznam();
        seznamZrno.dodajSeznam(seznam);

        novUps.setOdkljukan(use.getUse_odkljukan());
        novUps.setUporabnik(uporabnik);
        //novUps.setSeznam(seznam);

        return uporabnikseznamZrno.dodajUps(novUps);
    }

    public Seznamartikel dodajArtikelSeznamu(SeznamartikelDto sza){

        //ena
        if(sza.getSeznam() == null){
            System.out.println("ne obstaja");
            return null;
        }
        else{
            System.out.println("obstaja");
        }
        Seznam seznam = seznamZrno.pridobiSeznam((sza.getSeznam().getId_seznama()));
        Artikel artikel=new Artikel();
        artikel.setIme(sza.getArtikel().getIme());
        artikel.setArtikel_id(sza.getArtikel().getArtikel_id());
        artikel.setSt_nakupov(sza.getArtikel().getSt_nakupov());

        artikelZrno.dodajArtikel(artikel);

        Seznamartikel novSza = new Seznamartikel();
        novSza.setRead(sza.isRead());
        novSza.setWrite(sza.isWrite());
        novSza.setArtikel(artikel);
        novSza.setSeznam(seznam);

        return seznamartikelZrno.dodajSza(novSza);
    }

    public Seznamartikel dodajSeznamArtiklu(SeznamartikelDto sza){

        //ena
        if(sza.getSeznam() == null){
            System.out.println("ne obstaja");
            return null;
        }
        else{
            System.out.println("obstaja");
        }
        Seznam seznam = sza.getSeznam();
        Artikel artikel = artikelZrno.pridobiArtikel((sza.getArtikel().getArtikel_id()));

        seznamZrno.dodajSeznam(seznam);

        Seznamartikel novSza = new Seznamartikel();
        novSza.setRead(sza.isRead());
        novSza.setWrite(sza.isWrite());
        novSza.setArtikel(artikel);
        //novSza.setSeznam(seznam);

        return seznamartikelZrno.dodajSza(novSza);
    }

}

