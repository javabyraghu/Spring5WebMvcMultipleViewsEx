package in.nareshit.raghu.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nareshit.raghu.model.Student;

public class StudentPdfView extends AbstractPdfView {

	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document,
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {


		//file name (optional)
		response.addHeader("Content-Disposition", "attachment;filename=STUDENTS.pdf");

		//read data from Controller
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) model.get("list");
		
		Paragraph p = new Paragraph("WELCOME TO STUDENTS");
		document.add(p);
		
		PdfPTable tables = new PdfPTable(3);
		tables.addCell("ID");
		tables.addCell("NAME");
		tables.addCell("FEE");
		
		for(Student sob: list) {
			tables.addCell(sob.getStdId().toString());
			tables.addCell(sob.getStdName());
			tables.addCell(sob.getStdFee().toString());
		}
		
		document.add(tables);
		
	}
}
