package gov.bd.banbeis.controllers.secured;

import gov.bd.banbeis.controllers.shared.DivisionResource;
import gov.bd.banbeis.models.Division;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/secured/division")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MutableDivisionResource extends DivisionResource {
    @PUT
    public Uni<Division> saveOrUpdate(Division division){
        return division.persistOrUpdate();
    }

    @DELETE
    @Path("/{id}")
    public Uni<Boolean> delete(@PathParam("id") String id){
        return Division.deleteById(Integer.parseInt(id));
    }
}
