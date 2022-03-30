/*
package gov.bd.banbeis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import gov.bd.banbeis.controllers.secured.MutableDesignationResource;
import gov.bd.banbeis.models.Designation;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.smallrye.mutiny.Uni;
import org.apache.http.HttpStatus;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class DesignationResourceTest {

    @Inject
    MutableDesignationResource mutableDesignationResource;

    private String securedAPI = "/api/secured/designation";
    private String sharedAPI = "/api/shared/designation";

    @Test
    public void testDesignationResource() throws JsonProcessingException{
        String designation1 = "{\"name\": \"Assistant Programmer\", \"shortName\": \"AP\", \"grade\": 9, \"bn\": {\"name\": \"সহকারী প্রোগ্রামার\", \"shortName\": \"এপি\"}}";
        String designation2 = "{\"name\": \"Computer Operator\", \"shortName\": \"CO\", \"grade\": 13, \"bn\": {\"name\": \"কম্পিউটার অপারেটর\", \"shortName\": \"সিও\"}}";
        String designation3 = "{\"name\": \"Lab Assistant\", \"shortName\": \"LA\", \"grade\": 15, \"bn\": {\"name\": \"ল্যাব এসিস্‌টেন্ট\", \"shortName\": \"এলএ\"}}";

        Designation responsedDesignation1 =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(designation1)
                .when()
                .put(securedAPI)
                .then()
                .statusCode(200)
                .body(
                        "id", notNullValue(),
                        "name", is("Assistant Programmer"),
                        "shortName", is("AP"),
                        "grade", is(9),
                        "bn.name", is("সহকারী প্রোগ্রামার"),
                        "bn.shortName", is("এপি")
                )
                .extract()
                .body().as(Designation.class);

        Designation responsedDesignation2 =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(designation2)
                .when()
                .put(securedAPI)
                .then()
                .statusCode(200)
                .body(
                        "id", notNullValue(),
                        "name", is("Computer Operator"),
                        "shortName", is("CO"),
                        "grade", is(13),
                        "bn.name", is("কম্পিউটার অপারেটর"),
                        "bn.shortName", is("সিও")
                )
                .extract()
                .body().as(Designation.class);

        Designation responsedDesignation3 =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(designation3)
                .when()
                .put(securedAPI)
                .then()
                .statusCode(200)
                .body(
                        "id", notNullValue(),
                        "name", is("Lab Assistant"),
                        "shortName", is("LA"),
                        "grade", is(15),
                        "bn.name", is("ল্যাব এসিস্‌টেন্ট"),
                        "bn.shortName", is("এলএ")
                )
                .extract()
                .body().as(Designation.class);


        Designation[] designations = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(sharedAPI+"/all")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Designation[].class);

        Assertions.assertEquals(designations.length, 3);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(sharedAPI+"/"+responsedDesignation1.id.toString())
                .then()
                .statusCode(200)
                .body(
                        "id", is(responsedDesignation1.id.toString()),
                        "name", is(responsedDesignation1.name),
                        "shortName", is(responsedDesignation1.shortName),
                        "grade", is(responsedDesignation1.grade),
                        "bn.name", is(responsedDesignation1.bn.name),
                        "bn.shortName", is(responsedDesignation1.bn.shortName)
                );

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .delete(securedAPI+"/"+responsedDesignation1.id.toString())
                .then()
                .statusCode(204);
    }


    private Designation[] postDesignation(Designation designation){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(designation)
                .put("/api/secured/designation")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Designation[].class);
    }
}
*/
