package Zrna;

import entities.Artikel;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class BelezenjeKlicevZrno {

    private int st_klicev = 0;

    private Logger log = Logger.getLogger(BelezenjeKlicevZrno.class.getName());


    public void zgodilKlic(){
        st_klicev = st_klicev+1;
        //System.out.println("zaporedni klic: " + st_klicev);
        log.info("zaporedni klic: " + st_klicev);
    }
}
