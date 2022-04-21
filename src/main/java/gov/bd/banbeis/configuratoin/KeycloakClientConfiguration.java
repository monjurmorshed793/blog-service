package gov.bd.banbeis.configuratoin;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;


import javax.enterprise.context.ApplicationScoped;

public class KeycloakClientConfiguration {

    @ConfigProperty(name="keycloak-server-url")
    String authServer;
    @ConfigProperty(name="quarkus.oidc.client-id")
    String clientId;
    @ConfigProperty(name="quarkus.oidc.credentials.secret")
    String clientSecret;
    @ConfigProperty(name="keycloak-realm")
    String realm;

    @ApplicationScoped
    RealmResource realmResourceExtended(){
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(authServer)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
        return keycloak.realm(realm);
    }
}
