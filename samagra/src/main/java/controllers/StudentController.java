package controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.Student;
import entity.PersonDAO;
import service.StudentService;


@RestController
public class StudentController {
	 @RequestMapping(value="/")
	 public String receiveAll() throws IOException {
		 return "Student is working fine";
	 }
	 @RequestMapping(value="/getAllStudents")
	 public String getAllStudents() {
		 StudentService service=new StudentService();
		 return service.getAllStudent();
	 }
}
