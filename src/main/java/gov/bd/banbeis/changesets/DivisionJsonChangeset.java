package gov.bd.banbeis.changesets;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.bd.banbeis.models.Division;
import io.smallrye.mutiny.Uni;
import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisionJsonChangeset implements CustomTaskChange {

    private String file;
    private ResourceAccessor resourceAccessor;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public void execute(Database database) throws CustomChangeException {
        try{
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(resourceAccessor.openStream(null, file))
            );
            //ignore header
            String str = null;
            List<Division> divisions = new ArrayList<>();
            while ((str = in.readLine()) != null && !str.trim().equals("")) {
                ObjectMapper objectMapper = new ObjectMapper();
                Division division = objectMapper.readValue(str, Division.class);
                divisions.add(division);
            }
            Division.persist(divisions).subscribe().asCompletionStage();

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
