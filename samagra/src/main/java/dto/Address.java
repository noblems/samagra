package dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//(adrressId serial primary key, addressPersonId integer ,Addr1 varchar,Addr2 varchar,Addr3 varchar, city varchar, state varchar,pin varchar,createdDate varchar, updatedDate varchar,activeInd int)
@JacksonXmlRootElement(localName = "Address")
public class Address {
	@JacksonXmlProperty(isAttribute = true)
	private int addressId;
	@JacksonXmlProperty
	private String addr1;
	@JacksonXmlProperty
	private String addr2;
	@JacksonXmlProperty
	private String addr3;
	@JacksonXmlProperty
	private String city;
	@JacksonXmlProperty
	private String state;
	@JacksonXmlProperty
	private String pin;
	/*@JacksonXmlProperty
	private String createdDate;
	@JacksonXmlProperty
	private String updatedDate;*/
	@JacksonXmlProperty
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

	/*public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}*/

	public int getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}
}
