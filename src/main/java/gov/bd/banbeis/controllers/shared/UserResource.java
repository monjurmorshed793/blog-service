package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.services.keycloak.extend.RealmResourceExtended;
import io.smallrye.mutiny.Uni;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;

@Path("/api/shared/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    RealmResource realmResource;

    @GET
    @Path("/total-user")
    public Uni<Integer> getTotalUsers(){
       // return keycloakUserAPI.getTotalCount();
        return Uni.createFrom().item(realmResource.users().count());
    }

    @GET
    @Path("/all")
    public Uni<List<UserRepresentation>> getUsers(){
        realmResource.users();
        realmResource.users().userProfile();
        return Uni.createFrom().item(realmResource.users().list());
    }
}
