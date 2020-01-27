package entity;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
@Repository
public class AddressDAO {
	
	private int addressId;
	
	private int addressPersonId;
	 
	private String addr1;
	 
	private String addr2;
	 
	private String addr3;
	 
	private String city;
	 
	private String state;
	 
	private String pin;
	 
	private Date createdDate;
	 
	private Date updatedDate;
	 
	private int activeInd;
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}

	public int getAddressPersonId() {
		return addressPersonId;
	}

	public void setAddressPersonId(int addressPersonId) {
		this.addressPersonId = addressPersonId;
	}
}
