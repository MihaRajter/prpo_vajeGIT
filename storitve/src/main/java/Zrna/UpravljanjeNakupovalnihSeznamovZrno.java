package Zrna;

import Uprava.NakupovalniSeznamDto;
import entities.Seznam;
import entities.Uporabnik;

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

    @PostConstruct
    private void Init(){
            log.info("Inicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }
    @PreDestroy
    private void destroy(){
        log.info("Deinicializacija Zrna "+UporabnikiZrno.class.getSimpleName());
    }

    public Seznam ustvariSeznam(NakupovalniSeznamDto seznamDto){
        Uporabnik uporabnik = uporabnikiZrno.pridobiUporabnika(seznamDto);
        if(uporabnik == null){
            log.info("ne morm");
            return null;
        }
        Seznam seznam = new Seznam();
        //set stuff
        return seznamZrno.dodajSeznam(seznam);
    }

}
