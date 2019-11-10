package service.functionalities;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dto.Address;
import dto.Staff;
import entity.AddressDAO;
import entity.PersonDAO;
import entity.StaffDAO;
import service.basic.AddressService;
import service.basic.PersonService;
import service.basic.StaffService;

public class StaffFunctionsService {
	public void insertStaff(Staff staff) throws  Exception {
		try {
			StaffService staffService=new StaffService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			PersonDAO personDao=personService.extractPersonFromStaffDto(staff);
			personDao=personService.insertPerson(personDao);
			//AddressDAO addressDao=addressService.extractAddressFromStaffDto(staff);
			System.out.println("person id="+personDao.getFirstName());
			//addressDao.setAddressPersonId(personDao.getPersonId());
			//addressDao=addressService.insertAddress(addressDao);
			StaffDAO staffDao=staffService.extractStaffFromStaffDto(staff);
			staffDao.setStaffPersonId(personDao.getPersonId());
			//staffDao.setAddressId(addressDao.getAddressId());
			staffDao=staffService.insertStaff(staffDao);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*public PersonDAO getpersonById(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  return personMapper.getPersonById(personId);
		  }finally{
		   sqlSession.close();
		  }
		 }
	public Staff getStaffById(Integer staffId) {
		Staff staff=new Staff();
		try{

			PersonService personService = new PersonService();
			StaffService staffService = new StaffService();
			AddressService addressService = new AddressService();
			StaffDAO staffDao=staffService.getStaffById(staffId);
			PersonDAO personDao=personService.getPersonById(staffDao.getStaffPersonId());
			AddressDAO addressDao=addressService.getAddressById(staffDao.getStaffAddressId());
			Address address=addressService.wrapAddressToAddressDto(addressDao);
			staff.setStaffId(staffDao.getStaffId());
			staff.setRegisterNumber(staffDao.getRegisterNumber());
			staff.setAdmissionNumber(staffDao.getAdmissionNumber());
			staff.setFirstName(personDao.getLastName());
			staff.setMiddleName(personDao.getMiddleName());
			staff.setLastName(personDao.getLastName());
			staff.setDob(personDao.getDob());
			staff.setSex(personDao.getSex());
			staff.setPersonId(staffDao.getStaffPersonId());
			staff.setAddress(address);
			staff.setDivisionId(staffDao.getDivisionId());


		}catch(Exception e) {
			System.out.println("error occurred");
			staff.setStaffId(-1);
			staff.setMessage("No such staff available");
		}
		return staff;
	}*/

	public List<Staff> getAllStaff() throws Exception {

		List<Staff>staffs = new ArrayList<Staff>();
		StaffService staffService=new StaffService();
		PersonService personService= new PersonService();
		AddressService addressService=new AddressService();
		try{
			List<StaffDAO> staffDao=staffService.getAllStaff();
			System.out.println("number of staff"+staffDao.size());
			//Iterator staffIterator =  staffDao.iterator();
			for(int i=0;i<staffDao.size();i++){
				Staff staff=new Staff();
				System.out.println("stdao"+staffDao.get(i).getStaffPersonId());
				System.out.println("person "+personService.getPersonById(staffDao.get(i).getStaffPersonId()).getFirstName());
				AddressDAO addressDao=addressService.getAddressById(staffDao.get(i).getAddressId());
				staff=staffService.wrapStaffDto(staffDao.get(i),
						personService.getPersonById(staffDao.get(i).getStaffPersonId()));
				System.out.println("stude"+staff.getFirstName());
				staffs.add(staff);
			}


		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return staffs;
	}
	/*public void updateStaff(int staffId,Staff staff) throws Exception {
		try{
			StaffService staffService=new StaffService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			StaffDAO staffDaoexisting=staffService.getStaffById(staffId);
			if(staffDaoexisting!=null) {
				StaffDAO staffDao=staffService.extractStaffFromStaffDto(staff);
				staffDao.setStaffAddressId(staffDaoexisting.getStaffAddressId());
				staffDao.setDivisionId(staffDaoexisting.getDivisionId());
				staffDao.setStaffPersonId(staffDaoexisting.getStaffPersonId());
				AddressDAO addressDao=addressService.extractAddressFromStaffDto(staff);
				PersonDAO personDao=personService.extractPersonFromStaffDto(staff);
				//personDao.setPersonId(staffservice);
				staffDao=staffService.updateStaff(staffId, staffDao);
				System.out.println("in functionalities"+staffDao.getStaffId());
				addressDao=addressService.updateAddress(staffDaoexisting.getStaffAddressId(), addressDao);
				personDao=personService.updatePerson(staffDaoexisting.getStaffPersonId(), personDao);
			}else {
				throw new NoSuchElementException();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public void deleteStaff(Integer staffId) throws Exception {
		try {
			StaffService staffService=new StaffService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			StaffDAO staffDao=staffService.getStaffById(staffId);
			AddressDAO addressDao=addressService.deleteAddress(staffDao.getStaffAddressId());
			PersonDAO personDao=personService.deletePerson(staffDao.getStaffPersonId());
			staffDao=staffService.deleteStaff(staffId);
			System.out.println("my activ ind is"+staffDao.getActiveInd());
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}*/
}
