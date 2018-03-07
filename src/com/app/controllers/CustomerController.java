package com.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Booking;
import com.app.pojos.City;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;
import com.app.service.CustomerService;

import oracle.net.aso.s;

@Controller
@RequestMapping("/cust")
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	
	@RequestMapping("/register")
	public String showregistrationForm(Customer c,Model map)
    {
		
		List<City> li=service.getCity();
		//System.out.println("List City "+li);
		map.addAttribute("list_city",li);
		map.addAttribute("list_contype",service.getConnectionType());
		map.addAttribute("list_gender", service.getGender());
		map.addAttribute("list_usertype",service.getuserType());
		map.addAttribute("list_qua", service.getlistofQuastion());		
		return "register";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String filledregistrationForm(Customer c ,Model map)
    {
		c.setDeposit(0.0);
	    System.out.println("abc===============>>>>abc=========>>>>>>");
		String msg=service.registerCustomer(c);
		
		if(msg.equals("invalid"))
		{
			map.addAttribute("massage","mobile no or email alredy in use");
			map.addAttribute("cust_info", c);
			List<City> li=service.getCity();
			
			
			//System.out.println("List City "+li);
			map.addAttribute("list_city",li);
			map.addAttribute("list_contype",service.getConnectionType());
			map.addAttribute("list_gender", service.getGender());
			map.addAttribute("list_usertype",service.getuserType());
			map.addAttribute("list_qua", service.getlistofQuastion());
			return "register";
		}
	    map.addAttribute("sms",msg);
		return "redirect:/cust/customerlogin";
		        //customerlogin
	} 

	@RequestMapping("/customerlogin")
	public String customerloginForm(Customer c)
	{
		System.out.println("in customer login...from");
		return "customerlogin";
	}
	@RequestMapping(value="/customerlogin" ,method=RequestMethod.POST)
	public String customerValidate(Customer c,Model map,HttpSession hs)
	{
		Customer c1=service.validation(c.getEmail(),c.getPassword());
		if(c1 == null )
		{
			map.addAttribute("msg","invalid please try again..");
			return "customerlogin";
		}
		hs.setAttribute("cust_detail",c1);
		return "redirect:/cust/welcomecustomer";
	}
	
	
	
	
	
	@RequestMapping("/welcomecustomer")
	public String welcomecustomer(Customer c)
	{
		System.out.println("in customer login...from");
		return "welcomecustomer";
	}

	@RequestMapping("/booking")
	public String booking(Customer c,HttpSession hs,Model map,Booking b)
	{
		
		Stockdetail stockdetail = service.stock();
		Customer c1 = (Customer) hs.getAttribute("cust_detail");
		System.out.println("customer--------->ID  ===>"+c1.getCustomerId());
		System.out.println("customer--------->"+c1.getConnectiontype());
		//System.out.println("---------->"+stockdetail.getStockId());
		//"Cumersial","Deomastic")
		Booking lastbooking = service.getlastbooking(c1);
		 
		if(lastbooking != null)
		{
			 System.out.println("==========>>>>>>>>>>>>> boooooooooookkkkkkkk"+lastbooking.getBookingId());
			    
			    
		       SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
				
			    String currentdate=sdf.format(new Date());
		        String lastbookingdate=sdf.format(lastbooking.getBookingDate());
		        System.out.println("Booooooooookinggggg Date  ====>"+lastbookingdate+"===============>   "+currentdate);
		        try 
		        {
					Date d1 = sdf.parse(currentdate);
					Date d2=sdf.parse(lastbookingdate);
					
					long diff =d1.getTime() - d2.getTime();
					long diffDay=diff /(24*60*60*1000);
					
					System.out.print(diffDay + " days==========------>>>>>, ");
					if(diffDay < 1)
					{
					   map.addAttribute("msg","Sorry you cant book cylinder booking diff should 2 days");
	                    return "booking";
					}
				}
		        catch (ParseException e)
		        {
					System.out.println("exxxxeexexexexexexeeeeeexxexeexexxxxxxxxxxxxxexexe");
					e.printStackTrace();
				}
		}
		 
		 if(stockdetail.getConsumer() != 0)
		 {
		
			 if(c1.getConnectiontype().equals("Commercial"))
			 {
				 map.addAttribute("msg","Commercial Cylinder Avoilable......");
				 return "BookingProceed";	 
			 }
		 }
		 if(stockdetail.getDomestic() != 0)
		 {
			
			 if(c1.getConnectiontype().equals("Domestic"))
			 {
				 
				 map.addAttribute("msg","Deomastic Cylinder Avoilable......");
				 return "BookingProceed";	 
			 }
		 }
		 
		  map.addAttribute("msg","Cylinder not in stock....");
		  return "booking";
	}
	
	
	
	@RequestMapping(value="/booking",method=RequestMethod.POST)
	public String afterBooking(Booking b,Model map,HttpSession hs) throws ParseException
	{
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		
		Customer c1 = (Customer) hs.getAttribute("cust_detail");
		System.out.println("Customer   "+c1.getCustomerId());
		
		b.setCustomer(c1);
        
		b.setStatus("Pending");
        String dateStart=sdf.format(new Date());
        
        Date d1 = sdf.parse(dateStart);
        
		b.setBookingDate(d1);
		
		//Booking b1=service.booking(b);
		
		Booking b1=service.booking(b,c1);
		
		System.out.println("boob id  "+b1.getBookingId()+"Customer id "+b1.getCustomer().getCustomerId());
		//map.addAttribute("book_detail", b1);
		
		
		hs.setAttribute("book_detail", b1);
		return "redirect:/cust/receipt";
	}
	
	
	@RequestMapping("/receipt")
	public String receipt(Customer c,Model map,HttpSession hs)
	{
		System.out.println("in customer login...from");
		map.addAttribute("sms","Booking Details..");
		map.addAttribute("book_detail",hs.getAttribute("book_detail"));
		
		hs.setAttribute("book_details",hs.getAttribute("book_detail"));
		return "receipt";
	}
	
	@RequestMapping("/bookingstatus")
	public String bookingstatus(Booking b,Model map)
	{
		return "bookingstatus";
	}
	@RequestMapping(value="/bookingstatus",method=RequestMethod.POST)
	public String showbookingstatus(Booking b,Model map,HttpSession hs)
	{
		System.out.println("Boolig ID :"+b.getBookingId());
		Customer c1 =(Customer) hs.getAttribute("cust_detail");
		Booking b1=service.showbooking(b,c1);
		//System.out.println("Booking ---------->"+b1.getBookingDate());
		if(b1 == null)
		{
			return "redirect:/cust/bookingstatus";
		}
		hs.setAttribute("book_detail", b1);
		return "redirect:/cust/bookingstatus";
	}
	
	@RequestMapping("/showprofile")
	public String showprofile(HttpSession hs)
	{
		System.out.println("in show profile.....");
		return "showprofile";
	}	
	
	
	@RequestMapping("/updateprofile")
    public String updateprofile(Customer c,HttpSession hs,Model map)
    {
		System.out.println("in update ===>>");
		List<City> li=service.getCity();
		//System.out.println("List City "+li);
		
		map.addAttribute("list_city",li);
		map.addAttribute("list_contype",service.getConnectionType());
		map.addAttribute("list_gender", service.getGender());
		map.addAttribute("list_usertype",service.getuserType());
		map.addAttribute("list_usertype",service.getuserType());
		map.addAttribute("list_qua", service.getlistofQuastion());
		map.addAttribute("customerinfo",hs.getAttribute("cust_detail"));
		
		return "updateprofile";
    }
	
	
	@RequestMapping(value="/updateprofile",method=RequestMethod.POST)
	public String afterupdateprofile(Customer c,HttpSession hs,Model map)
	{
		
        if(c.getConnectiontype().equals("Commercial"))
        {
        	c.setDeposit(5000.0);  
        }
        else
        {
        	c.setDeposit(8000.0);
        }
        String msg=service.updatecustomer(c);
        
	    return "redirect:/cust/customerlogin";
	}
	
	///cust/forgotpassword
	@RequestMapping("/forgotpassword")
	public String forgotpasswordform(Customer c,HttpSession hs,Model map)
	{
		map.addAttribute("list_qua", service.getlistofQuastion());	
		return "forgotpassword";
	}
	
	@RequestMapping(value="/forgotpassword",method=RequestMethod.POST)
	public String forgotpassword(Customer c,HttpSession hs,Model map)
	{
		System.out.println("=======>  "+c.getSecurityAns()+"==========>>>> "+c.getSecurityQuaston());
        Customer c1 = service.detailsverification(c);
        if(c1 == null)
        {
        	System.out.println("================>>>>>>>in nulllllllllllll");
        	return "redirect:/cust/forgotpassword";
        }
        hs.setAttribute("customer",c1);
	    return "newpassword";
	}
	
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	public String newpassword(Customer c,HttpSession hs,Model map)
	{
		Customer customer=(Customer) hs.getAttribute("customer");
		customer.setPassword(c.getPassword());
		String msg = service.updatepassword(customer);
		
	    return "redirect:/cust/customerlogin";
	}

}
