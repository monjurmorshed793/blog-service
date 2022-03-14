package gov.bd.banbeis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import gov.bd.banbeis.models.Designation;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class DesignationResourceTest {
    @Test
    public void testSaveWhenIdIsNull() throws JsonProcessingException {
        Designation designation = new Designation();
        designation.name= "Assistant Programmer";
        designation.shortName= "AP";
        designation.grade = 9;

        Designation bnDesignation = new Designation();
        bnDesignation.name = "সহকারী প্রোগ্রামার";
        bnDesignation.shortName = "এপি";
        designation.bn   = bnDesignation;

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String postBody = objectWriter.writeValueAsString(designation);

        given()
                .body(postBody)
                .contentType("application/json")
                .when().put("/api/secured/designation")
                .then()
                .statusCode(200)
                .body("id", notNullValue(),
                "name", is("Assistant Programmer"),
                        "shortName", is("AP"),
                        "grade", is(9),
                        "bn.name", is("সহকারী প্রোগ্রামার"),
                        "bn.shortName", is("এপি")
                );
    }
}
