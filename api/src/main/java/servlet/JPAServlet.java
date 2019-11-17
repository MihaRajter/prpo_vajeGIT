package servlet;

import Zrna.ArtikelZrno;
import Zrna.SeznamZrno;
import Zrna.UporabnikiZrno;
import entities.Uporabnik;


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
        Uporabnik s = new Uporabnik("cene","novak");
        uporabnikiZrno.dodajUporabnika(s);

        resp.getWriter().println("<hr>");

        List<Uporabnik> list1 = uporabnikiZrno.getUporabniki();
        for(Uporabnik u: list1){
            resp.getWriter().println(u.getId() +", "+u.getIme() +" "+ u.getPriimek() + "<br>");
        }
        // izpis uporabnikov na spletno stran

    }
}