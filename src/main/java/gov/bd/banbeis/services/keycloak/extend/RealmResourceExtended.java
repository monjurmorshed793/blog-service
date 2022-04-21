package gov.bd.banbeis.services.keycloak.extend;

import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

import javax.ws.rs.Path;

public interface RealmResourceExtended extends RealmResource {
    @Path("users")
    KeycloakAdminUsersResource users();
}
