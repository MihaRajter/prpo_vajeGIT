package api.v1.viri;

import Zrna.SeznamZrno;
import Zrna.UporabnikiZrno;
import anotacije.BeleziKlice;
import com.kumuluz.ee.rest.beans.QueryParameters;
import entities.Seznam;
import entities.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
@Path("seznam")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@BeleziKlice
public class SeznamVir {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private SeznamZrno seznamZrno;

    @GET
    public Response pridobiUporabnike(){
        //return Response.ok(uporabnikiZrno.getUporabniki()).build();
        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long stSeznamov = seznamZrno.getSeznamiCount(query);

        return Response
                .ok(seznamZrno.getSeznami(query))
                .header("stevilo-uporabnikov",stSeznamov)
                .build();
    }

    @GET
    @Path("{id_seznama}")
    public Response pridobiUporanika(@PathParam("id_seznama") int id){
        Seznam seznam = seznamZrno.pridobiSeznam(id);

        if(seznam != null){
            return Response.ok(seznam).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    public Response dodajSeznam(Seznam seznam){

        return Response
                .status(Response.Status.CREATED)
                .entity(seznamZrno.dodajSeznam(seznam))
                .build();
    }

    @PUT
    @Path("{id_seznama}")
    public Response posodobiSeznam(@PathParam("id_seznama") int id_seznama, Seznam seznam){
        return Response
                .status(Response.Status.CREATED)
                .entity(seznamZrno.posodobiSeznam(id_seznama,seznam))
                .build();
    }
    @DELETE
    @Path("{id_seznama}")
    public Response odstraniSeznam(@PathParam("id_seznama") int id){
        return Response
                .status(Response.Status.OK)
                .entity(seznamZrno.odstraniSeznam(id))
                .build();
    }
}
