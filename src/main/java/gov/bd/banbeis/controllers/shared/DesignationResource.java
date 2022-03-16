package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Designation;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/shared/designation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DesignationResource {
    @GET
    @Path("/{id}")
    public Uni<Designation> get(@PathParam("id") String id){
        return Designation.findById(new ObjectId(id));
    }

    @GET
    @Path("/all")
    public Uni<List<Designation>> getAll(){
        return Designation.listAll();
    }
}
