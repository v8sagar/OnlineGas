package com.app.dao;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.City;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;

public interface CustomerDao 
{
	List<City> getCity();
	 String registerCustomer(String cityname, Customer c);
	 Customer validation(String email,String pass);
	 Stockdetail stock();
	// Booking booking(Booking b);
	 
	 Booking booking(Booking b,Customer c1);
	 
	 Booking showbooking(Booking b,Customer c1);
	 
	 String updatecustomer(String cityname, Customer c);
	 
	 Booking getlastbooking(Customer c);
	 
	 Customer detailsverification(Customer c);
	 
	 String updatepassword(Customer c);
}
