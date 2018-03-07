package com.app.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Booking;
import com.app.pojos.City;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;

@Repository

public class CustomerDaoImp implements CustomerDao 
{
	@Autowired
	private SessionFactory sf;

	@Override
	public List<City> getCity() 
	{
		System.out.println("in list dao city..");
		
		String hql="select c.cityName from City c ";
		return sf.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public String registerCustomer(String cityname, Customer c)
	{
		
		System.out.println("Name :====>>>>"+c.getFirstname());
		System.out.println("Name :====>>>>"+c.getEmail());
		System.out.println("Name :====>>>>"+c.getMobileno());
		
		String hql1 ="select  customer from Customer customer where customer.mobileno=:mobno or customer.email=:em";
		
		List<Customer> list = sf.getCurrentSession().createQuery(hql1).setParameter("mobno",c.getMobileno()).setParameter("em",c.getEmail()).list();
		
		System.out.println(list.toString());
		
		if(list.isEmpty())
		{
			System.out.println("inside list nullllllllllllllllllllllllllllllllllll");
	        String hql="select c from City c where c.cityName=:nm";
	        City c1 =(City) sf.getCurrentSession().createQuery(hql).setParameter("nm",cityname).uniqueResult();
		    c.setCity(c1);
		    Integer id =(Integer)sf.getCurrentSession().save(c);
	        return "Register Sucessfuly...at"+id+"..";
		}
		System.out.println("inside list nu00000000000000000000000000000000000000");
		return "invalid";
	}

	@Override
	public Customer validation(String email, String pass)  
	{
		String userType="Customer";
		Double deposit=0.0;
		System.out.println(userType+"email "+email+"pass "+pass);
	   
		String hql="select c from Customer c where c.email=:em and c.password=:ps and c.usertype=:us and c.deposit >:dp";
	   
	    Customer c = (Customer) sf.getCurrentSession().createQuery(hql).setParameter("em",email).setParameter("ps",pass).setParameter("us",userType).setParameter("dp",deposit).uniqueResult();
		//System.out.println("Custpomer info "+c.getCustomerId());
	    
	   
	    return c;
   
	}
	@Override
	public Booking getlastbooking(Customer customer) 
	{
		System.out.println("==========>>>>>>>>>>>>> boooooooooookkkkkkkk11111111111");
	    String hql2="select max(b.bookingId) from Booking b where b.customer=:cid";
	    Integer id =(Integer) sf.getCurrentSession().createQuery(hql2).setParameter("cid",customer).uniqueResult();
	   
	    System.out.println("==========>>>>>>>>>>>>> boooooooooookkkkkkkk2222222222222"); 
	    String hql3="select b from Booking b where b.bookingId=:ID ";
	    
	    Booking b1 =  (Booking) sf.getCurrentSession().createQuery(hql3).setParameter("ID",id).uniqueResult();
		return b1;
	}

	@Override
	public Stockdetail stock() 
	{
		String hql="select s from Stockdetail s where  s.stockId = (select max(s.stockId) from Stockdetail s)";
		
		return(Stockdetail)sf.getCurrentSession().createQuery(hql).uniqueResult();
		/*System.out.println("Inter max id :"+id);
		return null;*/
	}

	/*@Override
	public Booking booking(Booking b) 
	{
		System.out.println("---------------->in booking--------->");
	    Integer id =(Integer) sf.getCurrentSession().save(b);	
		String hql ="select b from Booking b where b.bookingId=:bi";
		Booking b1=(Booking) sf.getCurrentSession().createQuery(hql).setParameter("bi",id).uniqueResult();
	    
	    return b1;
	}*/
	
	
	
	@Override
	public Booking booking(Booking b, Customer c)
	{

		
		if(c.getConnectiontype().equals("Commercial"))//Commercial
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
			
		}

		System.out.println("---------------->in booking--------->");
	    Integer id =(Integer) sf.getCurrentSession().save(b);	
		String hql ="select b from Booking b where b.bookingId=:bi";
		Booking b1=(Booking) sf.getCurrentSession().createQuery(hql).setParameter("bi",id).uniqueResult();
	    
	    return b1;
		
	}
	

	@Override
	public Booking showbooking(Booking b,Customer c1) 
	{
		System.out.println("Customer   :"+c1.getCustomerId());
		String hql ="select b from Booking b where b.bookingId=:bi and b.customer=:cm";
		return (Booking) sf.getCurrentSession().createQuery(hql).setParameter("bi",b.getBookingId()).setParameter("cm",c1).uniqueResult();
	}

	@Override
	public String updatecustomer(String cityname, Customer c) 
	{ 
		String hql="select c from City c where c.cityName=:nm";
	    City c1 =(City) sf.getCurrentSession().createQuery(hql).setParameter("nm",cityname).uniqueResult();
		c.setCity(c1);
		sf.getCurrentSession().saveOrUpdate(c);
		return "update Sucessfully...";
	}

	@Override
	public Customer detailsverification(Customer c) 
	{
		String hql="select c from Customer c where c.email=:em and c.securityQuaston=:sq and c.securityAns=:sa";
		
		return (Customer) sf.getCurrentSession().createQuery(hql).setParameter("em",c.getEmail()).setParameter("sq", c.getSecurityQuaston()).setParameter("sa",c.getSecurityAns()).uniqueResult();
	}

	@Override
	public String updatepassword(Customer c)
	{
	    sf.getCurrentSession().saveOrUpdate(c);
		return "passowrd change";
	}


	

	
	
	

}
