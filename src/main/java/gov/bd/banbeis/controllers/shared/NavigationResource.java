package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Navigation;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/shared/navigation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NavigationResource {

    @GET
    @Path("/{id}")
    public Uni<Navigation> get(@PathParam("id") String id){
        return Navigation.findById(new ObjectId(id));
    }


    @GET
    @Path("/all")
    public Uni<List<Navigation>> getAll(){
        return Navigation.listAll(Sort.by("sequence"));
    }
}
