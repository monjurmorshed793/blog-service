package gov.bd.banbeis.changesets;

import gov.bd.banbeis.models.District;
import gov.bd.banbeis.models.Division;
import gov.bd.banbeis.models.LanguageType;
import io.smallrye.common.annotation.Blocking;
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

public class DistrictChangeset implements CustomTaskChange {

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
                    new InputStreamReader(resourceAccessor.openStream(null, file), "UTF-8")
            );
            //ignore header
            String str = in.readLine();
            List<District> districts = new ArrayList<>();
            while ((str = in.readLine()) != null && !str.trim().equals("")) {
                str = str.replaceAll("\"","");
                List<String> objects = new ArrayList<String>(Arrays.asList(str.split(",")));
                District district = new District();
                district.districtId = Integer.parseInt(objects.get(0));
                district.divisionId = Integer.parseInt(objects.get(1));
                district.name = new LanguageType();
                district.name.english =  objects.get(2);
                district.name.bangla = objects.get(3);
                district.lat = objects.get(4);
                district.lon = objects.get(5);
                district.url = objects.get(6);
                districts.add(district);
            }
            District.persist(districts).subscribeAsCompletionStage();

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
