package api.v1.viri;

import Zrna.UporabnikiZrno;
import anotacije.BeleziKlice;
import com.kumuluz.ee.rest.beans.QueryParameters;
import entities.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@ApplicationScoped
@Path("uporabnik")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@BeleziKlice

public class UporabnikiVir {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private UporabnikiZrno uporabnikiZrno;

    @GET
    public Response pridobiUporabnike(){
        //return Response.ok(uporabnikiZrno.getUporabniki()).build();
        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        Long stUporabnikov = uporabnikiZrno.getUporabnikiCount(query);

        return Response
                .ok(uporabnikiZrno.getUporabniki(query))
                .header("stevilo-uporabnikov",stUporabnikov)
                .build();
    }

    @GET
    @Path("{Uporabnik_id}")
    public Response pridobiUporabnika(@PathParam("Uporabnik_id") int id){
        Uporabnik uporabnik = uporabnikiZrno.pridobiUporabnika(id);

        if(uporabnik != null){
            return Response.ok(uporabnik).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    public Response dodajUporabnika(Uporabnik uporabnik){

        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.dodajUporabnika(uporabnik))
                .build();
    }

    @PUT
    @Path("{Uporabnik_id}")
    public Response posodobiUporabnika(@PathParam("Uporabnik_id") int id, Uporabnik uporabnik){
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.posodobiUporabnika(id,uporabnik))
                .build();
    }
    @DELETE
    @Path("{Uporabnik_id}")
    public Response odstraniUporabnika(@PathParam("Uporabnik_id") int id){
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikiZrno.odstraniUporabnika(id))
                .build();
    }
}
