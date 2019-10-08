package mappers;

import java.util.List;

import entity.AddressDAO;

public interface AddressMapper {
	public void insertAddress(AddressDAO address);
	 
	 public AddressDAO getAddressById(Integer addressId);
	 
	 public List<AddressDAO> getAllAddress();
	 
	 public void updateAddress(AddressDAO address);
	 
	 public void deleteAddress(Integer addressId);
}
