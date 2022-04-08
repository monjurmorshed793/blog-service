package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Division;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class DivisionGResource {

    @Query("getAllDivision")
    @Description("Get all divisions")
    public Uni<List<Division>> getAll(){
        return Division.listAll();
    }

    @Query("getDivisionById")
    public Uni<Division> getById(String divisionId){
        return Division.findById(divisionId);
    }

    @Mutation("createDivision")
    @Description("Create a new division")
    public Uni<Division> createDivision(String name, String bnName, String url){
        Division division = new Division();
        division.name.english = name;
        division.name.bangla = bnName;
        division.url = url;
        return division.persist();
    }

    @Mutation("updateDivision")
    @Description("Update a division")
    public Uni<Division> updateDivision(String divisionId, String name, String bnName, String url){
        Uni<Division> division = Division.findById(divisionId);
        return division
                .onItem()
                .transformToUni(d-> {
                    d.name.english = name;
                    d.name.bangla = bnName;
                    d.url = url;
                    return d.update();
                });
    }

    @Mutation
    @Description("Delete a division")
    public Uni<Boolean> deleteDivision(String divisionId){
        return Division.deleteById(divisionId);
    }
}
