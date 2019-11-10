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
import dto.Staff;
import service.functionalities.StaffFunctionsService;

@RestController
public class StaffController {
	 @RequestMapping(value="/Staffs")
	 public String receiveAll() throws IOException {
		 return "staffs service is working fine";
	 }
	 @RequestMapping(value="/Staffs/getAllStaffs")
	 public List<Staff> getAllStaffs() throws Exception {
		 StaffFunctionsService service=new StaffFunctionsService();
		 	try {
				return service.getAllStaff();
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
				
			}
	 }
	 /*@RequestMapping(value="/Staffs/getStaffById")
	 public Staff getStaffById(@RequestParam(value="Id")int id) throws IOException {
		 StaffFunctionsService service=new StaffFunctionsService();
		 return service.getStaffById(id);
	 }*/
	  @RequestMapping(value="/Staffs/insertStaff",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	 public Response insertStaff(@RequestBody Staff student) throws IOException {
		 StaffFunctionsService service=new StaffFunctionsService();
		 	Response response=new Response();
			try {
				service.insertStaff(student);
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
	 /*@RequestMapping(value="/deleteStaffById")
	 public Response deleteStaffById(@RequestParam(value="Id")int id) throws IOException {
		 StaffFunctionsService service=new StaffFunctionsService();
		 	Response response=new Response();
			try {
				service.deleteStaff(id);
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
	 @RequestMapping(value="/updateStaffById")
	 public Response updateStaffById(@RequestParam(value="Id")int id,@RequestBody Staff student) throws IOException {
		 StaffFunctionsService service=new StaffFunctionsService();
		 	Response response=new Response();
			try {
				service.updateStaff(id,student);
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
	 public Address wrapAddressDto(AddressDAO addressDao) {
		 Address address=new Address();
		 address.setAddr1(addressDao.getAddr1());
		 address.setAddr2(addressDao.getAddr2());
		 address.setAddr3(addressDao.getAddr3());
		 address.setCity(addressDao.getCity());
		 address.setState(addressDao.getState());
		 address.setPin(addressDao.getPin());
		 return address;
	 }
	 */
}
