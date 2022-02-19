package gov.bd.banbeis;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReactiveGreetingResource {

    @GET
    public Response hello() {
        return Response.ok("Hello RESTEasy Reactive").build();
    }

    @GET
    @Path("/test")
    public Response helloForTest() {
        TestDTO testDTO = new TestDTO();
        testDTO.setResponse("Hello RESTEasy Reactive");
        return Response.ok(testDTO).build();
    }
}