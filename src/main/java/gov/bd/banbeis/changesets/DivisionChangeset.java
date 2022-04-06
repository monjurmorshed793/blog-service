package gov.bd.banbeis.changesets;

import gov.bd.banbeis.models.Division;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.repackaged.org.apache.commons.lang3.ClassLoaderUtils;
import liquibase.resource.ResourceAccessor;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisionChangeset implements CustomTaskChange {



    // to hold the parameter value (csv file location)
    private String file;

    private ResourceAccessor resourceAccessor;

    public String getFile(){
        return file;
    }

    public void setFile(String file){
        this.file = file;
    }

    @Override
    @Blocking
    public void execute(Database database) throws CustomChangeException {
        try{
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(resourceAccessor.openStream(null, file))
            );
            //ignore header
            String str = in.readLine();
            List<Division> divisions = new ArrayList<>();
            while ((str = in.readLine()) != null && !str.trim().equals("")) {
                List<String> objects = new ArrayList<String>(Arrays.asList(str.split(",")));
                Division division = new Division();
                division.divisionId = objects.get(0);
                division.name =  objects.get(1);
                division.bnName = objects.get(2).toString();
                division.url = objects.get(3);
                divisions.add(division);
                division.persist().subscribe().asCompletionStage();
            }
            Uni<Long> totalCountAfterCompletion = Division.count();
            Long totalCountBlocked = totalCountAfterCompletion.await().indefinitely();
            System.out.println("total count---->"+ totalCountBlocked.toString());
           //Uni<Void> savedDivisions = Division.persist(divisions);

        }catch (Exception e){
            throw new CustomChangeException(e);
        }
    }

    @Override
    public String getConfirmationMessage() {
        return null;
    }

    @Override
    public void setUp() throws SetupException {

    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {
        this.resourceAccessor = resourceAccessor;
    }

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }
}
