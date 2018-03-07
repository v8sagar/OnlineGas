package com.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Booking;
import com.app.pojos.City;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService
{
	@Autowired
	private CustomerDao dao;

	@Override
	public List<String> getGender() 
	{
		
		return  Arrays.asList("M","F");
	}

	@Override
	public List<City> getCity()
	{
		System.out.println("in register form  ..111 22222  111 ");
		return dao.getCity();
	}

	@Override
	public List<String> getConnectionType()
	{
		
		return  Arrays.asList("Commercial","Domestic");
	}

	@Override
	public List<String> getuserType()
	{
		
		return Arrays.asList("Customer");
	}

	@Override
	public String registerCustomer(Customer c)
	{
	    System.out.println("CITY ======>>"+c.getCity().getCityName());    	
		
	    return dao.registerCustomer(c.getCity().getCityName(),c);
	}

	@Override
	public Customer validation(String email, String pass) 
	{
		
		return dao.validation(email, pass);
	}

	@Override
	public Stockdetail stock() 
	{
		
		return dao.stock();
	}

	/*@Override
	public Booking booking(Booking b) {
		
		return dao.booking(b);
	}*/
	
	@Override
	public Booking booking(Booking b,Customer c1) {
		
		return dao.booking(b,c1);
	}

	@Override
	public Booking showbooking(Booking b,Customer c1) {
		
		return dao.showbooking(b,c1);
	}

	@Override
	public String updatecustomer(Customer c) 
	{
		System.out.println("CITY ======>>"+c.getCity().getCityName());  
	    	
		return dao.updatecustomer(c.getCity().getCityName(),c);
	}

	@Override
	public Booking getlastbooking(Customer c) {
		
		return dao.getlastbooking(c);
	}

	@Override
	public List<String> getlistofQuastion() 
	{
		return  Arrays.asList("Whate is your Pets Name ","Whate is your nick Name","Whate is your Place of Birth ");
	}

	@Override
	public Customer detailsverification(Customer c) {
		// TODO Auto-generated method stub
		return dao.detailsverification(c);
	}

	@Override
	public String updatepassword(Customer c) {
		
		return dao.updatepassword(c);
	}

}
