package com.app.service;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;

public interface AdminService 
{
	 Customer validation(String email,String pass);
	 Integer addStock(Stockdetail s);
	 List<Customer> listofRequestingCustomer();
	 String addDeposit(String mobileno);
	 String ChangeStatus(String mobileno);
	 List<Booking> listofBookingRequest();
	 List<Stockdetail> showstock();
}
