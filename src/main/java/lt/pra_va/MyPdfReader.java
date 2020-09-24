package lt.pra_va;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class MyPdfReader {

    public static String read(String filePath, int startPage, int endPage) {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setStartPage(startPage);
                stripper.setEndPage(endPage);
                String text = stripper.getText(document);
                return text;
            } else {
                System.out.println("DOCUMENT - ENCRYPTED");
            }
            document.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
