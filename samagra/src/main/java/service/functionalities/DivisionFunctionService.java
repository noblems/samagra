package service.functionalities;

import dto.Staff;
import entity.DivisionDAO;
import entity.PersonDAO;
import entity.StaffDAO;
import service.basic.DivisionService;
import service.basic.PersonService;
import service.basic.StaffService;

public class DivisionFunctionService {
public Staff getStaffOfDivisionById(int divisionId) throws Exception {
	DivisionService ds=new DivisionService();
	try {
		DivisionDAO divisionDao=ds.getDivisionById(divisionId);
		StaffService ss= new StaffService();
		PersonService personService= new PersonService();
		StaffDAO staffDao=ss.getStaffById(divisionDao.getStaffId());
		PersonDAO personDao=personService.getPersonById(staffDao.getStaffPersonId());
		return ss.wrapStaffDto(staffDao, personDao);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw e;
	}
}
}
