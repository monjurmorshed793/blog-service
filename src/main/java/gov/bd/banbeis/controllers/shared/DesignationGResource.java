package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Designation;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.graphql.*;

import javax.validation.Valid;
import java.util.List;

@GraphQLApi
public class DesignationGResource {

    @Query("designations")
    @Description("Get all designations")
    public Uni<List<Designation>> getAllDesignations(){
        return Designation.listAll();
    }

    @Query("designation")
    @Description("Get designation by id")
    public Uni<Designation> getDesignationById(@Name("designationId") String designationId){
        return Designation.findById(new ObjectId(designationId));
    }

    @Mutation("createDesignation")
    @Description("Save designation")
    public Uni<Designation> createDesignation(String name,String shortName,Integer grade,String bnName,String bnShortName){
        Designation designation = new Designation();
        designation.name = name;
        designation.shortName = shortName;
        designation.grade = grade;
        designation.bn  = new Designation();
        designation.bn.name = bnName;
        designation.bn.shortName = bnShortName;
        return designation.persist();
    }

/*
    @Mutation("saveDesignation")
    public Uni<Designation> saveDesignation(@Source Designation designation){
        return designation.persist();
    }
*/

    @Mutation
    public Uni<Designation> updateDesignation(String id, String name, String shortName, Integer grade, String bnName, String bnShortName){
        Uni<Designation> designationUni = Designation.findById(new ObjectId(id));
        return designationUni.onItem()
                .transformToUni(d-> {
                    d.name = name;
                    d.shortName = shortName;
                    d.grade = grade;
                    d.bn.name = bnName;
                    d.bn.shortName = bnShortName;

                    return d.update();
                });

    }

    @Mutation
    public Uni<Boolean> deleteDesignation(String id){
        return Designation.deleteById(new ObjectId(id));
    }
}
