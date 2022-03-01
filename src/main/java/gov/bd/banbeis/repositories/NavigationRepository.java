package gov.bd.banbeis.repositories;

import gov.bd.banbeis.models.Navigation;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NavigationRepository implements PanacheMongoRepository<Navigation> {

}
