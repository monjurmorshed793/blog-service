package gov.bd.banbeis.services.report;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfTrueTypeFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import gov.bd.banbeis.models.Division;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static com.itextpdf.kernel.pdf.PdfName.*;

@ApplicationScoped
public class DivisionReportService {

    public ByteArrayOutputStream generatePdfBoxReport() throws Exception{

        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage(PDRectangle.A4);
        document.addPage(firstPage);
        InputStream inputStream = getClass().getResourceAsStream("/fonts/nikosh.ttf");
        var font1 = PDType0Font.load(document, inputStream, false);

        var kalpurushStream = getClass().getResourceAsStream("/fonts/lohit.ttf");
        var kalpurushFont = PDType0Font.load(document, kalpurushStream, false);


        PDPageContentStream content = new PDPageContentStream(document, firstPage);
        content.beginText();

        content.setFont(font1, 14);
        content.newLineAtOffset(30, 750);
//        content.showText("Hello world");
        Uni<List<Division>> divisionsUni = Division.listAll();
        List<Division> divisions = divisionsUni.await().indefinitely();
        for(Division division: divisions){
            content.showText(division.name.bangla+" ");
        }
        content.showText("মঞ্জুর-ই-মোর্শেদ");
        content.endText();
        content.close();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.save(out);
        document.close();
        return out;
    }


    @Blocking
    public ByteArrayOutputStream generateAllDivisionReport() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream  =new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document document = new Document(pdfDocument);


        Uni<List<Division>> divisionsUni = Division.listAll();
        List<Division> divisions = divisionsUni.await().indefinitely();

        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();

        Cell cell = null;

        cell = new Cell();
        cell.add(generateHeaderParagraph("S/L"));
        table.addCell(cell);
        cell = new Cell();
        cell.add(generateHeaderParagraph("Name"));
        table.addCell(cell);
        cell = new Cell();
        cell.add(generateHeaderParagraph("Bangla Name"));
        table.addCell(cell);


        Integer sequence = 0;
        for(Division division: divisions){
            sequence+=1;
            table.addCell(generateBodyCell(sequence.toString()));
            table.addCell(generateBodyCell(division.name.english));
            table.addCell(generateBodyCell(division.name.bangla));
        }

        document.add(table);
        document.close();
        return byteArrayOutputStream;
    }

    private Paragraph generateHeaderParagraph(String content) throws IOException {
        return generateHeaderParagraph(content, null);
    }

    private Paragraph generateHeaderParagraph(String content, TextAlignment textAlignment) throws IOException {
        PdfFont headerFont = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD, "UTF-8");

        Paragraph paragraph = new Paragraph(content);
        paragraph.setFont(headerFont);
        paragraph.setFontSize(14);
        paragraph.setTextAlignment(textAlignment==null? TextAlignment.LEFT: textAlignment);
        return paragraph;
    }

    private Cell generateBodyCell(String content) throws IOException {
        return generateBodyCell(content, null);
    }

    private Cell generateBodyCell(String content, TextAlignment textAlignment) throws IOException {

/*        BufferedImage img = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 14);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(content);
        int height = fm.getHeight();
        g2d.drawString(content, 0, fm.getAscent());
        g2d.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img,"", baos);
        PdfStream pdfStream = new PdfStream(baos.toByteArray());

        Image image = new Image(new PdfImageXObject(pdfStream));

        Cell cell = new Cell();
        cell.add(image);
        return cell;*/

        Cell cell = new Cell();
        PdfFont bodyFont = PdfFontFactory.createFont(StandardFonts.HELVETICA, "UTF-8");
        FontProgram kalpurshFontProgram = FontProgramFactory.createFont("fonts/nikosh.ttf");
        PdfFont kalpurushFont = PdfFontFactory.createFont(kalpurshFontProgram, IdentityH.getValue());
        Paragraph paragraph = new Paragraph(content);
        paragraph.setFont(kalpurushFont);
        paragraph.setFontSize(14);
        paragraph.setPadding(5);
        paragraph.setTextAlignment(textAlignment==null? TextAlignment.LEFT: textAlignment);

        return cell.add(paragraph);
    }


}
