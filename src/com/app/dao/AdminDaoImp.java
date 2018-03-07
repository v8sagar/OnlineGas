package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;



@Repository
@Transactional
public class AdminDaoImp implements AdminDao 
{
	@Autowired
	private SessionFactory sf;
	

	@Override
	public Customer validation(String email, String pass) 
	{
		String userType="admin";
		System.out.println(userType+"email "+email+"pass "+pass);
	   
		String hql="select c from Customer c where c.email=:em and c.password=:ps and c.usertype=:us";
	   
	    Customer c = (Customer) sf.getCurrentSession().createQuery(hql).setParameter("em",email).setParameter("ps",pass).setParameter("us",userType).uniqueResult();
	    return c;
	}
	public Integer addStock(Stockdetail s)
	{
		System.out.println("Consumer "+s.getConsumer());
		
		Integer Id =(Integer)sf.getCurrentSession().save(s);
		
		System.out.println("Stock added at ID "+Id);
		return Id;
	}
	@Override
	public List<Customer> listofRequestingCustomer() {
		System.out.println("in DAO   list of Customer.....");
		String usertype="Customer";
		Double deposit=0.0;
		String hql="select c from Customer c where c.deposit=:dp and c.usertype=:ut";
		return sf.getCurrentSession().createQuery(hql).setParameter("dp",deposit).setParameter("ut",usertype).list();
	}
	@Override
	public String addDeposit(String mobileno) 
	{
		String hql="select c from Customer c where c.mobileno=:mn";
		Customer c  =(Customer) sf.getCurrentSession().createQuery(hql).setParameter("mn",mobileno).uniqueResult();
		System.out.println("Customer Deposit :"+c.getDeposit()+"Customer Id "+c.getCustomerId());
		String str=c.getConnectiontype();
		
		if(str.equals("Commercial")) //Commercial
		{
			c.setDeposit(5000.0);
			sf.getCurrentSession().save(c);
		}
		else 
		{
		   c.setDeposit(8000.0);
		   sf.getCurrentSession().save(c);
		}
		return "added sucessfull..";
		
	}
	@Override
	public List<Booking> listofBookingRequest() 
	{
		String str="Pending";
		String hql="select b from Booking b where b.status=:st";
		return sf.getCurrentSession().createQuery(hql).setParameter("st",str).list();
	}
	
	
	@Override
	public String ChangeStatus(String mobileno)
	{

		String hql="select c from Customer c where c.mobileno=:mn";
		Customer c  =(Customer) sf.getCurrentSession().createQuery(hql).setParameter("mn",mobileno).uniqueResult();
       
		/*if(c.getConnectiontype().equals("Commercial"))//Commercial
		{
			String hql2="select s from Stockdetail s where s.stockId = (select max(s.stockId) from Stockdetail s)";
			
			Stockdetail stock=(Stockdetail)sf.getCurrentSession().createQuery(hql2).uniqueResult();
			int Id = stock.getConsumer();
			//System.out.println("integer....========> "+Id);
			Integer id = Id - 1;
			stock.setConsumer(id);
			sf.getCurrentSession().saveOrUpdate(stock);
			
		}
		if(c.getConnectiontype().equals("Domestic"))//Domestic
		{
			String hql2="select s from Stockdetail s where s.stockId = (select max(s.stockId) from Stockdetail s)";
			
			Stockdetail stock=(Stockdetail)sf.getCurrentSession().createQuery(hql2).uniqueResult();
			int Id = stock.getDomestic();
			//System.out.println("integer....========> "+Id);
			Integer id = Id - 1;
			stock.setDomestic(id);
			sf.getCurrentSession().saveOrUpdate(stock);
			
		}*/
		String str="Pending";
		String hql1="select b from Booking b where b.customer.customerId=:id and b.status=:st";
		Booking b1 =(Booking) sf.getCurrentSession().createQuery(hql1).setParameter("id",c.getCustomerId()).setParameter("st",str).uniqueResult();
		System.out.println("--------->"+b1.getBookingId()+"=======>"+b1.getStatus());
		b1.setStatus("On The Way");
		
		return "added sucessfull..";
		
	}
	@Override
	public List<Stockdetail> showstock() 
	{
		String hql="select s from Stockdetail s where s.stockId > ((select max(s.stockId) from Stockdetail s) - 5)";
		
		return sf.getCurrentSession().createQuery(hql).list();
	}

}
