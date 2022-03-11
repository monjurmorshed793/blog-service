package gov.bd.banbeis.controllers.secured;

import gov.bd.banbeis.models.Navigation;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/secured/navigation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MutableNavigationResource extends Navigation {
    @POST
    @Path("/save")
    public Uni<Navigation> save(Navigation navigation) throws Exception{
        return navigation.persist();
    }

    @PUT
    @Path("/update")
    public Uni<Navigation> update(Navigation navigation) throws Exception{
        if(navigation.id==null)
            throw new Exception("ID should not be null.");
        return navigation.update();
    }

    @DELETE
    @Path("/delete/{id}")
    public Uni<Boolean> delete(@PathParam("id") String id) throws Exception{
        return Navigation.deleteById(id);
    }

}
