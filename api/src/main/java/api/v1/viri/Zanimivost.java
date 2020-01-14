package api.v1.viri;


import Zrna.SeznamZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("number")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Zanimivost {

    @Inject
    private SeznamZrno SeznamZrno;

    @GET
    public Response Zanimivost(){
        return Response.ok(SeznamZrno.getZanimivost()).build();
    }
}