package gov.bd.banbeis.services.keycloak.extend;

import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface KeycloakAdminUsersResource extends UsersResource {
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(UserRepresentation userRepresentation);
}
