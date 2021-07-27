package in.nareshit.raghu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.nareshit.raghu.model.Student;

@Controller
public class StudentController {

	@GetMapping("/show")
	public String showPage() {
		return "StdPage";//.jsp
	}
	
	@GetMapping("/excel")
	public ModelAndView showExcel() {
		List<Student> list = Arrays.asList(
					new Student(101, "AA", 200.0),
					new Student(102, "BB", 300.0),
					new Student(103, "CC", 400.0),
					new Student(104, "DD", 500.0),
					new Student(105, "EE", 600.0)
				);
		ModelAndView m = new ModelAndView();
		m.setViewName("studentsExcel");//.xlsx
		
		m.addObject("list", list);
		return m;
	}
}
