package gov.bd.banbeis.controllers.shared;

import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/shared/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {



    @GET
    @Path("/total-user")
    public Uni<Long> getTotalUsers(){
        return Uni.createFrom().item(1L);
    }
}
