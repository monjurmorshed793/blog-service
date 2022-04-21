/*
package gov.bd.banbeis.services.keycloak;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.keycloak.authorization.client.AuthzClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class RequestUUIDHeaderFactory implements ClientHeadersFactory {
    @Inject
    AuthzClient authzClient;
    @Inject
    SecurityIdentity securityIdentity;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        result.add("access_token", authzClient.obtainAccessToken().getToken());
        return result;
    }
}
*/
