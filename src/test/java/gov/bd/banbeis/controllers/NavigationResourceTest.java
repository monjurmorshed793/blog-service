package gov.bd.banbeis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import gov.bd.banbeis.models.Navigation;
import io.quarkus.test.junit.QuarkusTest;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class NavigationResourceTest {

    @Test
    public void testSaveWhenIdIsNull() throws JsonProcessingException {
       /* Navigation dashboard = new Navigation();
        dashboard.route="/dashboard";
        dashboard.label="dashboard";
        dashboard.icon = "dashboard-icon";

        Navigation employeeInfo = new Navigation();
        employeeInfo.route="/employeeInfo";
        employeeInfo.label="Personal Info";
        employeeInfo.icon="personal-icon";

        Navigation configuration = new Navigation();
        configuration.route="/configuration";
        configuration.label="configuration";
        configuration.icon = "configuration-icon";
        configuration.child = Arrays.asList(dashboard, employeeInfo);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String postBody = objectWriter.writeValueAsString(configuration);

        given()
                .body(postBody)
                .contentType("application/json")
                .when().post("/navigation/save")
                .then()
                .statusCode(200);*/
    }

    @Test
    public void testUpdate() throws JsonProcessingException {
      /*  Navigation dashboard = new Navigation();
        dashboard.id= ObjectId.get();
        dashboard.route="/dashboard";
        dashboard.label="dashboard";
        dashboard.icon = "dashboard-icon";
        dashboard.child = new ArrayList<>();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String postBody = objectWriter.writeValueAsString(dashboard);

        given()
                .body(postBody)
                .contentType("application/json")
                .when().put("/navigation/update")
                .then()
                .statusCode(200);*/
    }
}
