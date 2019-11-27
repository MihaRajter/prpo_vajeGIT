package api.v1.viri;

import Zrna.UporabnikiZrno;
import entities.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("uporabniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UporabnikiVir {

    @Inject
    private UporabnikiZrno uporabnikiZrno;

    @GET
    public Response pridobiUporabnike(){
        return Response.ok(uporabnikiZrno.getUporabniki()).build();
    }

    @GET
    @Path("{id}")
    public Response pridobiUporanika(@PathParam("id") int id){
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
    @Path("{id}")
    public Response posodobiUporabnika(@PathParam("id") int id, Uporabnik uporabnik){
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.posodobiUporabnika(id,uporabnik))
                .build();
    }
    @DELETE
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") int id){
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikiZrno.odstraniUporabnika(id))
                .build();
    }
}
