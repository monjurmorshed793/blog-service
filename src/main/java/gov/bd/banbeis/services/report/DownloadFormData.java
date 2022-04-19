package gov.bd.banbeis.services.report;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class DownloadFormData {
    @RestForm
    public String name;

    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public ByteArrayInputStream file;
}
