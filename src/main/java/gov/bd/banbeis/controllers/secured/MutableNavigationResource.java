package gov.bd.banbeis.controllers.secured;

import gov.bd.banbeis.models.Navigation;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/secured/navigation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MutableNavigationResource extends Navigation {
    @POST
    @Path("/save")
    @Blocking
    public Uni<Navigation> save(Navigation navigation) throws Exception{
        navigation.sequence = Integer.parseInt((Navigation.count().await().indefinitely()+1)+"");
        return navigation.persist();
    }

    @PUT
    @Path("/update")
    public Uni<Navigation> update(Navigation navigation) throws Exception{
        return navigation.update();
    }

    @DELETE
    @Path("/delete/{id}")
    public Uni<Boolean> delete(@PathParam("id") String id) throws Exception{
        return Navigation.deleteById(new ObjectId(id));
    }

}
