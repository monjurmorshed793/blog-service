package gov.bd.banbeis.controllers.secured;

import gov.bd.banbeis.controllers.shared.DesignationResource;
import gov.bd.banbeis.models.Designation;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/secured/designation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MutableDesignationResource extends DesignationResource {

    @PUT
    public Uni<Designation> saveOrUpdate(Designation designation){
        return designation.persistOrUpdate();
    }

    @DELETE
    @Path("/{id}")
    public Uni<Boolean> delete(@PathParam("id") String id){
        return Designation.deleteById(new ObjectId(id));
    }

}
