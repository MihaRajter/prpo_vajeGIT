package api.v1.viri;

import Zrna.UporabnikiZrno;
import entities.Uporabnik;
import org.eclipse.persistence.oxm.MediaType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("uporabniki")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UporabnikiVir {

    @Inject
    private UporabnikiZrno uporabnikiZrno;

    @GET
    public Response pridobiUporabnike(){
        return Response.ok(uporabnikiZrno.pridobiUporabnika()).build();
    }

    @GET
    @Path("{id}")
    public Response pridobiUporanika(@PathParam("id") Integer id){
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
    public Response posodobiUporabnika(@PathParam("id") Integer id, Uporabnik uporabnik){
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.posodobiUporabnika(id,uporabnik))
                .build();
    }
    @DELETE
    @Path("{id}")
    public Response odstraniUporabnika(@PathParam("id") Integer id){
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikiZrno.odstraniUporabnika(id))
                .build();
    }
}