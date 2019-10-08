package controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Student;
import service.StudentService;


@RestController
public class StudentController {
	 @RequestMapping(value="/")
	 public String receiveAll() throws IOException {
		 return "student service is working fine";
	 }
	 @RequestMapping(value="/getAllStudents")
	 public List<Student> getAllStudents() {
		 StudentService service=new StudentService();
		 return service.getAllStudent();
	 }
	 @RequestMapping(value="/getStudentById")
	 public Student getStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentService service=new StudentService();
		 return service.getStudentById(id);
	 }
	 @RequestMapping(value="/insertStudent",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE)
	 public void insertStudent(@RequestBody Student student) throws IOException {
		 StudentService service=new StudentService();
		 service.insertStudent(student);
	 }
	 @RequestMapping(value="/deleteStudentById")
	 public String deleteStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentService service=new StudentService();
		 return service.deleteStudent(id);
	 }
	 @RequestMapping(value="/updateStudentById")
	 public String updateStudentById(@RequestParam(value="Id")int id,@RequestBody Student student) throws IOException {
		 StudentService service=new StudentService();
		 //System.out.print(id);
		 return service.updateStudent(id,student);
	 }
	 
}
