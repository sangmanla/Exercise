package pdfMerge;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class Combine {
	public static void main(String[] args) throws COSVisitorException, IOException {
		String path = "C:\\Users\\sam\\Desktop\\제출서류\\스캔\\";
		String[] files = {"img006.pdf", "img007.pdf"};
		
		PDFMergerUtility ut = new PDFMergerUtility();
		
		for(String file : files){
			ut.addSource(new File(path + file));
		}
		
		ut.setDestinationFileName(path + "Combined.pdf");
		ut.mergeDocuments();
	}
}
