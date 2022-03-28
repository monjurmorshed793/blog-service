package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Designation;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class DesignationGResource {

    @Query("allDesignations")
    @Description("Get all designations")
    public Uni<List<Designation>> getAllDesignations(){
        return Designation.listAll();
    }
}
