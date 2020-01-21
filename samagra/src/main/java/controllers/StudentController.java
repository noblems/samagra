package controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Response;
import dto.Student;
import service.basic.StudentService;
import service.functionalities.StudentFunctionsService;


@RestController
public class StudentController {
	 @RequestMapping(value="/Students")
	 public String receiveAll() throws IOException {
		 return "student service is working fine";
	 }
	 @RequestMapping(value="/Students/getAllStudents")
	 public List<Student> getAllStudents() throws Exception {
		 StudentFunctionsService service=new StudentFunctionsService();
		 	try {
				return service.getAllStudent();
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
				
			}
	 }
	 @RequestMapping(value="/Students/getStudentById")
	 public Student getStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentFunctionsService service=new StudentFunctionsService();
		 return service.getStudentById(id);
	 }
	  @RequestMapping(value="/Students/insertStudent",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	 public Response insertStudent(@RequestBody Student student) throws IOException {
		 StudentFunctionsService service=new StudentFunctionsService();
		 	Response response=new Response();
			try {
				service.insertStudent(student);
				response.setResponseCode(200);
				return response;
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setResponseCode(500);
				response.setMessage(e.getMessage());
				return response;
			}
		
	 }
	 @RequestMapping(value="/deleteStudentById")
	 public Response deleteStudentById(@RequestParam(value="Id")int id) throws IOException {
		 StudentFunctionsService service=new StudentFunctionsService();
		 	Response response=new Response();
			try {
				service.deleteStudent(id);
				response.setResponseCode(200);
				return response;
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setResponseCode(500);
				response.setMessage(e.getMessage());
				return response;
			}
	 }
	 @RequestMapping(value="/updateStudentById")
	 public Response updateStudentById(@RequestParam(value="Id")int id,@RequestBody Student student) throws IOException {
		 StudentFunctionsService service=new StudentFunctionsService();
		 	Response response=new Response();
			try {
				service.updateStudent(id,student);
				response.setResponseCode(200);
				return response;
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setResponseCode(500);
				response.setMessage(e.getMessage());
				return response;
			} 
	 }
	 /*public Address wrapAddressDto(AddressDAO addressDao) {
		 Address address=new Address();
		 address.setAddr1(addressDao.getAddr1());
		 address.setAddr2(addressDao.getAddr2());
		 address.setAddr3(addressDao.getAddr3());
		 address.setCity(addressDao.getCity());
		 address.setState(addressDao.getState());
		 address.setPin(addressDao.getPin());
		 return address;
	 }*/
	 
}
