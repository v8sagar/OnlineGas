package com.app.dao;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;

public interface AdminDao 
{
	 Customer validation(String email,String pass);
	 Integer addStock(Stockdetail s);
	 List<Customer> listofRequestingCustomer();
	 String addDeposit(String mobileno);
	 List<Booking> listofBookingRequest();
	 String ChangeStatus(String mobileno);
	 List<Stockdetail> showstock();
}
