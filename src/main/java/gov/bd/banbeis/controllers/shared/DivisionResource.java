package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Division;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/shared/division")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DivisionResource {

    @GET
    @Path("/{id}")
    public Uni<Division> get(@PathParam("id") String id){
        return Division.findById(Integer.parseInt(id));
    }

    @GET
    @Path("/all")
    public Uni<List<Division>> getAll(){
        return Division.listAll();
    }
}
