package gov.bd.banbeis.repositories;

import gov.bd.banbeis.models.Designation;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DesignationRepository implements PanacheMongoRepository<Designation> {

}
