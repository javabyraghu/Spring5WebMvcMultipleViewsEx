package in.nareshit.raghu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nareshit.raghu.model.Student;

public class StudentExcelView extends AbstractXlsxView {

	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
		
		//file name (optional)
		response.addHeader("Content-Disposition", "attachment;filename=STUDENTS.xlsx");
		
		//create one new Sheet
		Sheet sheet = workbook.createSheet("STUDNTS-DATA");
		
		//read data from Controller
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) model.get("list");
		
		setHeader(sheet);
		setBody(sheet,list);
	}

	private void setHeader(Sheet sheet) {
		int rowNum = 0;
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("FEE");
	}

	private void setBody(Sheet sheet, List<Student> list) {
		int rowNum = 1;
		for(Student sob: list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(sob.getStdId());
			row.createCell(1).setCellValue(sob.getStdName());
			row.createCell(2).setCellValue(sob.getStdFee());
		}
	}
}
