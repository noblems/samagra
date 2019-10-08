package exceptions;

public class StudentFunctionServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int personDao;
	private int addressDao;
	private int studentDao;
	private String Message;
	public int getPersonDao() {
		return personDao;
	}
	public void setPersonDao(int personDao) {
		this.personDao = personDao;
	}
	public int getAddressDao() {
		return addressDao;
	}
	public void setAddressDao(int addressDao) {
		this.addressDao = addressDao;
	}
	public int getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(int studentDao) {
		this.studentDao = studentDao;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
