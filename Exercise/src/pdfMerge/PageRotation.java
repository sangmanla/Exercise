package pdfMerge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PageRotation {
	public static final String path = "C:/Users/sam/Desktop/제출서류/스캔/5. Anna Cho Passport/";
	
	public static final String extension = ".pdf";
	public static final String SRC = path + "img001" + extension;
    public static final String DEST = SRC + "rotated" + extension;
    
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PageRotation().manipulatePdf(SRC, DEST);
    }
 
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfDictionary page;
        for (int p = 1; p <= n; p++) {
            page = reader.getPageN(p);
            page.put(PdfName.ROTATE, new PdfNumber(180));
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
}
