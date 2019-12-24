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


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    private Client httpClient;

    @PostConstruct
    public void init() {
        httpClient = ClientBuilder.newClient();
        String baseUrl = "http://localhost:8081/v1";
    }

    String sporocilo = httpClient
            .target("http://localhost:8081/v1")
            .request().get(new GenericType<String>() {
            });
}
