package servlet;
import java.util.Random;

import Uprava.DeloArtikelDto;
import Uprava.DeloUporabnikDto;
import Uprava.UporabnikiseznamDto;
import Zrna.*;
import entities.Artikel;
import entities.Seznam;
import entities.Uporabnik;
import entities.Uporabnikseznam;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    @Inject
    private ArtikelZrno artikelZrno;
    @Inject
    private SeznamZrno seznamZrno;
    @Inject
    private UporabnikiZrno uporabnikiZrno;
    @Inject
    private UpravljanjeNakupovalnihSeznamovZrno upravljanjeNakupovalnihSeznamovZrno;
    @Inject
    private UporabnikseznamZrno uporabnikseznamZrno;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
/*
        PrintWriter writer = resp.getWriter();
        writer.append("<br>Uporabniki:<br>");
   */     System.out.println("lole");
        //uporabnikiZrno.getUporabniki().stream().forEach(u -> writer.append(u.toString() + "<br> <br>"));

        resp.getWriter().println("Uporabniki: ");
        List<Uporabnik> list = uporabnikiZrno.getUporabniki();
        for(Uporabnik u: list){
            resp.getWriter().println(u.getId() +", "+u.getIme() +" "+ u.getPriimek() + "<br>");
        }


        List<Uporabnik> list1 = uporabnikiZrno.getUporabniki();
        for(Uporabnik u: list1){
            resp.getWriter().println(u.getId() +", "+u.getIme() +" "+ u.getPriimek() + "<br>");
        }
        Uporabnik g = new Uporabnik("cene","novak");
        uporabnikiZrno.dodajUporabnika(g);
        Seznam s=new Seznam("seznam1");
        Random rand=new Random();

        s.setId_seznama(rand.nextInt());

        Artikel a=new Artikel();
        a.setSt_nakupov(0);
        a.setIme("zobnapasta");
        a.setArtikel_id(rand.nextInt());

        DeloUporabnikDto unsz=new DeloUporabnikDto(false,g,s);
        upravljanjeNakupovalnihSeznamovZrno.dodajUporabnikuSeznam(unsz);
        DeloArtikelDto unsz2=new DeloArtikelDto(false,false, a, s );



        resp.getWriter().println("<hr>");
        for(Uporabnik u: list1){
            resp.getWriter().println(u.getId() +", "+u.getIme() +" "+ u.getPriimek() + "<br>");
        }
        resp.getWriter().println("<hr> tuka so seznami");
        List<Uporabnikseznam> sezlist = uporabnikseznamZrno.getUps();
        for(Uporabnikseznam u: sezlist){
            resp.getWriter().println(u.getId_ups() +", "+u.isOdkljukan()+", "+ u.getUporabnik().getIme()+  "<br>");
        }


        // izpis uporabnikov na spletno stran
/*
        Seznam s = new Seznam("seznam1");
        s.setId_seznama(8231);

        seznamZrno.dodajSeznam(s);

        UporabnikiseznamDto unsz = new UporabnikiseznamDto(false,g,s);

        upravljanjeNakupovalnihSeznamovZrno.dodajUporabnikSeznamu(unsz);
        resp.getWriter().println("<hr>");
        for(Uporabnik u: list1){
            resp.getWriter().println(u.getId() +", "+u.getIme() +" "+ u.getPriimek() + "<br>");
        }
        resp.getWriter().println("<hr> tuka so seznami");
        List<Uporabnikseznam> sezlist = uporabnikseznamZrno.getUps();
        for(Uporabnikseznam u: sezlist){
            resp.getWriter().println(u.getId_ups() +", "+u.isOdkljukan()+", "+ u.getUporabnik().getIme()+  "<br>");
        }

*/
    }
}