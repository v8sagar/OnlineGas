package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.AdminDao;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;


@Service 
public class AdminServiceImp implements AdminService
{
	@Autowired 
	private AdminDao dao;
	@Override
	public Customer validation(String email, String pass)
   {   System.out.println("in   service "+email+"pass "+pass);
		
		return dao.validation(email, pass);
	}
	
	@Override
	public Integer addStock(Stockdetail s) 
	{
		System.out.println("Consumer "+s.getConsumer()+"  Domesatic "+s.getDomestic());
		
		return  dao.addStock(s);
	}

	@Override
	public List<Customer> listofRequestingCustomer() {
		
		System.out.println("in sevice .....list  cust");
		List<Customer> li=dao.listofRequestingCustomer();
		System.out.println("list "+li.toString());
		return  li;
	}

	@Override
	public String addDeposit(String mobileno) {
		
		return dao.addDeposit(mobileno);
	}

	@Override
	public List<Booking> listofBookingRequest()
	{
		return dao.listofBookingRequest();
	}

	@Override
	public String ChangeStatus(String mobileno) {
		
		return dao.ChangeStatus(mobileno);
	}

	@Override
	public List<Stockdetail> showstock() {
		
		return dao.showstock();
	}


}
