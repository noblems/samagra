package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Response;
import dto.Student;
import exceptions.StudentFunctionServiceException;
import service.StudentFunctionsService;


@RestController
public class StudentController {
	 @RequestMapping(value="/")
	 public String receiveAll() throws IOException {
		 return "student service is working fine";
	 }
	/* @RequestMapping(value="/getAllStudents")
	 public List<Student> getAllStudents() {
		 StudentService service=new StudentService();
		 return service.getAllStudent();
	 }
	 @RequestMapping(value="/getStudentById")
	 public Student getStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentService service=new StudentService();
		 return service.getStudentById(id);
	 }*/
	 @RequestMapping(value="/insertStudent",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	 public Response insertStudent(@RequestBody Student student) throws IOException {
		 StudentFunctionsService service=new StudentFunctionsService();
		 	Response response=new Response();
			try {
				service.insertStudent(student);
				response.setResponseCode(200);
				return response;
			} catch (exceptions.StudentFunctionServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setResponseCode(500);
				response.setMessage(e.getMessage());
				return response;
				
			}
		
	 }
	 /*@RequestMapping(value="/deleteStudentById")
	 public String deleteStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentService service=new StudentService();
		 return service.deleteStudent(id);
	 }
	 @RequestMapping(value="/updateStudentById")
	 public String updateStudentById(@RequestParam(value="Id")int id,@RequestBody Student student) throws IOException {
		 StudentService service=new StudentService();
		 //System.out.print(id);
		 return service.updateStudent(id,student);
	 }*/
	 
}
