package mappers;

import java.util.List;

import entity.PersonDAO;

public interface PersonMapper {
	public void insertPerson(PersonDAO person);
	 
	 public PersonDAO getPersonById(Integer personId);
	 
	 public List<PersonDAO> getAllPerson();
	 
	 public void updatePerson(PersonDAO person);
	 
	 public void deletePerson(Integer personId);

}
