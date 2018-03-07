package com.app.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Stockdetail;
import com.app.service.AdminService;

@Controller
@RequestMapping("/admin")

public class AdminController 
{
		@Autowired
		private AdminService service;

		@RequestMapping("/login")
		public String showLoginForm(Customer c)
        {
			System.out.println("in show login form ");
			return "adminlogin";
		}
		
		@RequestMapping(value="/login" ,method=RequestMethod.POST)
		public String validate(Model map,Customer c,HttpSession hs)
		{
			Customer c1 =new Customer();
			System.out.println("email"+c.getEmail());
			
			c1=service.validation(c.getEmail(),c.getPassword());
			System.out.println("in show login form " + c);
			
			if(c1 == null)
			{
				map.addAttribute("msg","invalid entry try agin.");
				return "adminlogin";
			}
			
			hs.setAttribute("msg",c1);
			return "redirect:/admin/welcomeadmin";
		}
		@RequestMapping("/welcomeadmin")
		public String welcomeadmin(Customer c) 
		{
			System.out.println("in show login form " + c);
			return "welcomeadmin";
		}
		//admin/logout
		@RequestMapping("/logout")
		public String logout(HttpSession hs,Model map) 
		{
			System.out.println("in log out");
			
			map.addAttribute("msg",hs.getAttribute("msg.firstName"));
			hs.invalidate();
			return "logout";
		}
		
		@RequestMapping("/stock")
		public String stockForm(Stockdetail s,Model map) 
		{
			System.out.println("in stock");
			SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
			map.addAttribute("date",sdf.format(new Date()));
			return "stock";
		}
		
		
		@RequestMapping(value="/stock",method=RequestMethod.POST)
		public String addStock(Stockdetail s,HttpSession hs,Model map)
		{
			if(s.getConsumer() == null && s.getDomestic()== null)
			{
				System.out.println("============>>>>>>>>>>>>>>>>>>>>>>>>");
				hs.setAttribute("stock_msg","All field are required...");
				return "redirect:/admin/stock";
			}
	        hs.invalidate();
			map.addAttribute("msg", "stock added ....");
			Integer Id =service.addStock(s);
			
			System.out.println("Integere "+Id);
			
			map.addAttribute("sms","stock added at id : "+Id+"...");
			return "stock";
		}
		
		@RequestMapping("/listofrequest")
		public String listofRequest(Customer c,Model map,HttpSession hs)
		{
			List<Customer> li= service.listofRequestingCustomer();
			System.out.println("after getting list.....");
			if(li == null )
			{
				map.addAttribute("sms","no Pending New Connection request...");
				return "listofrequest";
			}
			hs.setAttribute("list",li);
			map.addAttribute("sms","New Connection request...");
			  return "listofrequest";
		}
		
		@RequestMapping(value="/listofrequest",method=RequestMethod.POST)
		public String afterRequest(Customer c,Model map,HttpSession hs)
		{
			System.out.println("Customer object ..:  "+c.getMobileno()+"  Another  ");
			if(c.getMobileno() == null)
			{
				System.out.println("in11111111111 statement...");
				return "redirect:/admin/listofrequest";
			}
			String str=service.addDeposit(c.getMobileno());
			System.out.println("mssage   :"+str);
			return "redirect:/admin/listofrequest";
		}
		
		
		
		
		
		@RequestMapping("/listofbookingrequest")
		public String showlistofbookingrequest(Customer c,Model map,HttpSession hs)
		{
			List<Booking> b1 =service.listofBookingRequest();
			
			if(b1 == null)
			{
				System.out.println("===========> in n8ulllllllllllll");
				map.addAttribute("s","No Booking Request.....");
			    
				return "listofbookingrequest";
				
			}
			hs.setAttribute("list_book", b1);
			map.addAttribute("sms","Booking Request..... ");
			return "listofbookingrequest";
		}
		
		
		@RequestMapping(value="/listofbookingrequest",method=RequestMethod.POST)
		public String acceptbookingrequest(Customer c,Model map,HttpSession hs)
		{
			String book="booking";
			System.out.println("Customer object ..:  "+c.getMobileno()+"  Another  ");
			if(c.getMobileno() == null)
			{
				System.out.println("in11111111111 statement...");
				return "redirect:/admin/listofbookingrequest";
			}
			
			String str = service.ChangeStatus(c.getMobileno());
			System.out.println("mssage   :"+str);
			return "redirect:/admin/listofbookingrequest";
		}
		
		@RequestMapping("/showstock")
		public String showstock(Stockdetail sd ,Model map)
		{
			List<Stockdetail> liststock = service.showstock();
			if(liststock == null)
			{
				System.out.println("=======>>>>");
				return "stock";
			}
			map.addAttribute("list",liststock);
			return "showstock";
		}


}
