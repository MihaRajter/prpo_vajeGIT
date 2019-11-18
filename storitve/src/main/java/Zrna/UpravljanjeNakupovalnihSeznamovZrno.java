package Zrna;

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

    public Uporabnikseznam dodajSeznamUporabniku(UporabnikiseznamDto use){

        //ena
        Uporabnik uporabnik = uporabnikiZrno.pridobiUporabnika(use.getUporabnik().getId());

        Seznam novSez = new Seznam();
        novSez.setNaziv("seznam2");

        seznamZrno.dodajSeznam(novSez);

        Uporabnikseznam novUps = new Uporabnikseznam();
        novUps.setOdkljukan(use.isOdkljukan());
        novUps.setSeznam(novSez);
        //novUps.setUporabnik(uporabnik);

        return uporabnikseznamZrno.dodajUps(novUps);
    }

    public Uporabnikseznam dodajUporabnikSeznamu(UporabnikiseznamDto use){

        //ena
        if(use.getSeznam()== null){
            System.out.println("ne obstaja");
            return null;
        }
        else{
            System.out.println("obstaja");
        }
        Seznam seznam = seznamZrno.pridobiSeznam(use.getSeznam().getId_seznama());

        Uporabnik novUpr = new Uporabnik();
        novUpr.setIme("crtomir");
        novUpr.setPriimek("kek");

        uporabnikiZrno.dodajUporabnika(novUpr);

        Uporabnikseznam novUps = new Uporabnikseznam();
        novUps.setOdkljukan(use.isOdkljukan());
        novUps.setUporabnik(novUpr);
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
        Seznam seznam = seznamZrno.pridobiSeznam(sza.getSeznam().getId_seznama());

        Artikel novArt = new Artikel();
        novArt.setIme("crtomir");
        novArt.setSt_nakupov(0);

        artikelZrno.dodajArtikel(novArt);

        Seznamartikel novSza = new Seznamartikel();
        novSza.setRead(sza.isRead());
        novSza.setWrite(sza.isWrite());
        novSza.setArtikel(novArt);
        //novSza.setSeznam(seznam);

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
        Artikel artikel = artikelZrno.pridobiArtikel((sza.getArtikel().getArtikel_id()));

        Seznam novSez = new Seznam();
        novSez.setNaziv("seznam2");

        seznamZrno.dodajSeznam(novSez);

        Seznamartikel novSza = new Seznamartikel();
        novSza.setRead(sza.isRead());
        novSza.setWrite(sza.isWrite());
        novSza.setArtikel(artikel);
        //novSza.setSeznam(novSez);



        return seznamartikelZrno.dodajSza(novSza);
    }

}

