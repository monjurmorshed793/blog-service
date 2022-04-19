package gov.bd.banbeis.controllers.shared;

import gov.bd.banbeis.models.Division;
import gov.bd.banbeis.services.report.DivisionReportService;
import gov.bd.banbeis.services.report.DownloadFormData;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Path("/api/shared/division")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DivisionResource {
    @Inject
    DivisionReportService divisionReportService;

    @GET
    @Path("/{id}")
    public Uni<Division> get(@PathParam("id") String id){
        return Division.findById(Integer.parseInt(id));
    }

    @GET
    @Path("/all")
    public Uni<List<Division>> getAll(){
        return Division.listAll();
    }

    @GET
    @Path("/report")
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public DownloadFormData generateReport() throws Exception {
        DownloadFormData downloadFormData = new DownloadFormData();
        downloadFormData.name="Division Report";
        ByteArrayOutputStream buffer = divisionReportService.generatePdfBoxReport();
        byte[] bytes = buffer.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        downloadFormData.file = byteArrayInputStream;
        return downloadFormData;
    }

/*    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReportResponse() throws IOException{
        ByteArrayOutputStream buffer = divisionReportService.generateAllDivisionReport();
        byte[] bytes = buffer.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return Response
                .ok(byteArrayInputStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment:filename=division.pdf")
                .build();
    }*/

/*    private StreamingOutput streamReport(){
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                try{
                    divisionReportService.generateAllDivisionReport(output);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }*/
}
