package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Address;
import dto.Student;
import entity.AddressDAO;
import mappers.AddressMapper;

public class AddressService {

	public AddressDAO insertAddress(AddressDAO addressDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
			addressDao.setCreatedDate(new Date());
			addressDao.setActiveInd(1);
			addressMapper.insertAddress(addressDao);
			
			sqlSession.commit();
			return addressDao;
		}finally{
			sqlSession.close();
		}
	}
	public AddressDAO getAddressById(Integer addressId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{

			AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
			return addressMapper.getAddressById(addressId);
			
		}catch(Exception e) {
			System.out.println("error occurred");
			AddressDAO addressDaoerror=new AddressDAO();
			addressDaoerror.setAddressId(-1);
			return addressDaoerror;
		}finally{
			sqlSession.close();
		}
	}

	public List<AddressDAO> getAllAddress() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
			try {
			AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
			return addressMapper.getAllAddress();
		}catch(Exception e) {
			System.out.println("error occurred");
			AddressDAO addresserror=new AddressDAO();
			addresserror.setAddressId(-1);
			return (List<AddressDAO>) addresserror;
		}finally{
			sqlSession.close();
			
		}
	}
	public AddressDAO updateAddress(int addressId,AddressDAO addressDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
			addressDao.setUpdatedDate(new Date());
			addressMapper.updateAddress(addressDao);

			sqlSession.commit();
			return addressDao;
		}catch(Exception e) {
			sqlSession.rollback();
			System.out.println("error occurred");
			AddressDAO addressDaoerror=new AddressDAO();
			addressDaoerror.setAddressId(-1);
			return addressDaoerror;
		}finally{
			sqlSession.close();
		}
	}

	
	public AddressDAO deleteAddress(Integer addressId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
			AddressDAO addressDao=addressMapper.getAddressById(addressId);
			addressMapper.deleteAddress(addressId);
			sqlSession.commit();
			return addressDao;
		}catch(Exception e) {
			sqlSession.rollback();
			System.out.println("error occurred");
			AddressDAO addressDaoerror=new AddressDAO();
			addressDaoerror.setAddressId(-1);
			return addressDaoerror;
		}finally{
			sqlSession.close();
		}
	}
	public AddressDAO extractAddressFromStudentDto(Student student) {
		AddressDAO addressDao=new AddressDAO();
		Address address=student.getAddress();
		addressDao.setAddr1(address.getAddr1());
		addressDao.setAddr2(address.getAddr2());
		addressDao.setAddr3(address.getAddr3());
		addressDao.setCity(address.getCity());
		addressDao.setState(address.getState());
		addressDao.setPin(address.getPin());
		return addressDao;
	}
	public AddressDAO extractAddressFromAddressDto(Address address) {
		AddressDAO addressDao=new AddressDAO();
		addressDao.setAddr1(address.getAddr1());
		addressDao.setAddr2(address.getAddr2());
		addressDao.setAddr3(address.getAddr3());
		addressDao.setCity(address.getCity());
		addressDao.setState(address.getState());
		addressDao.setPin(address.getPin());
		return addressDao;
	}
}