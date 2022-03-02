package gov.bd.banbeis.controllers;

import gov.bd.banbeis.models.Navigation;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/navigation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NavigationResource {

    @GET
    @Path("/{id}")
    public Uni<Navigation> get(@PathParam("id") String id){
        return Navigation.findById(new ObjectId(id));
    }

    @POST
    @Path("/save")
    public Uni<Navigation> save(Navigation navigation) throws Exception{
        return navigation.persist();
    }

    @PUT
    @Path("/update")
    public Uni<Navigation> upda(Navigation navigation) throws Exception{
        if(navigation.id==null)
            throw new Exception("ID should not be null.");
        return navigation.update();
    }

    @GET
    @Path("/all")
    public Uni<List<Navigation>> getAll(){
        return Navigation.listAll();
    }
}
