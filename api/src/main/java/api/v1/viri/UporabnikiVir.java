package api.v1.viri;

import Zrna.UporabnikiZrno;
import anotacije.BeleziKlice;
import com.kumuluz.ee.rest.beans.QueryParameters;
import entities.Uporabnik;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.eclipse.jetty.http2.api.Session;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URL;

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

    private Client httpClient;
    String baseUrl="";

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        baseUrl = "http://localhost:8081/v1";
    }



    @Operation(description = "Returns list of users.", summary = "Users list", tags = "users", responses = {
            @ApiResponse(responseCode = "200",
                    description = "List of users",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = Uporabnik.class))),
                    headers = {@Header(name = "stevilo-uporabnikov", schema = @Schema(type = "long"))}
            )})
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

    @Operation(description = "Returns details of user.", summary = "user details", tags = "users", responses = {
            @ApiResponse(responseCode = "200",
                    description = "details of user",
                    content = @Content(
                            schema = @Schema(implementation = Uporabnik.class))
            )})
    @GET
    @Path("{Uporabnik_id}")
    public Response pridobiUporabnika(@Parameter(
            description = "identifikator uporabnika za branje",
            required = true) @PathParam("Uporabnik_id") Integer id) {
        Uporabnik uporabnik = uporabnikiZrno.pridobiUporabnika(id);

        if(uporabnik != null){
            return Response.ok(uporabnik).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    @Operation(description = "dodaj Uporabnika.", summary = "user dodaj", tags = "users", responses = {
            @ApiResponse(responseCode = "201",
                    description = "uporabnik dodan"),
            @ApiResponse(responseCode = "405", description = "napaka")})
    @POST
    public Response dodajUporabnika(@RequestBody(
            description = "dodajanje uporabnikov",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = Uporabnik.class)))
            Uporabnik uporabnik){

        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.dodajUporabnika(uporabnik))
                .build();
    }
    @Operation(description = "posodobi Uporabnika.", summary = "user posodobi", tags = "users", responses = {
            @ApiResponse(responseCode = "200",
                    description = "uporabnik dodan"),
            })
    @PUT
    @Path("{Uporabnik_id}")
    public Response posodobiUporabnika( @Parameter(description = "Id uporabnika za update",
            required = true) @PathParam("Uporabnik_id") int id, @RequestBody(
                    description="DTO objekt za posodabljanje", required = true,
                    content = @Content(
                            schema = @Schema(implementation = Uporabnik.class))) Uporabnik uporabnik){
        return Response
                .status(Response.Status.CREATED)
                .entity(uporabnikiZrno.posodobiUporabnika(id,uporabnik))
                .build();
    }
    @Operation(description = "Odstrani uporabnika" , summary = "Brisanje uporabnika",
    tags = "users", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "uspešno odstranjen uporabnik"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "neuspešno, uporabnik ni najden"
            )
    })

    @DELETE
    @Path("{Uporabnik_id}")
    public Response odstraniUporabnika(@Parameter(description = "id uporabnika za brisanje",
    required = true)@PathParam("Uporabnik_id") int id){
        return Response
                .status(Response.Status.OK)
                .entity(uporabnikiZrno.odstraniUporabnika(id))
                .build();
    }


}
