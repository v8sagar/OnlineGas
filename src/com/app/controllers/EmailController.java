package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Booking;
import com.app.pojos.Customer;

@Controller
@RequestMapping("/email")
public class EmailController
{
	@Autowired
	private JavaMailSender sender;
	
	
	
	@RequestMapping("/receipt")
	public String SendEmail(HttpSession hs,Model map)
	{//cust_detail
		//book_details
		System.out.println("inside mail service .........");
		SimpleMailMessage message =new SimpleMailMessage();
		
		Customer customer = (Customer) hs.getAttribute("cust_detail");
		System.out.println(customer.getFirstname()+" "+customer.getEmail());
		
		Booking booking=(Booking) hs.getAttribute("book_details");
		System.out.println("booking ID "+booking.getStatus());
		
		
		message.setTo(customer.getEmail());//client mail
		message.setSubject("Booking Receipt ");
		message.setText("Mr/Mrs : "+customer.getFirstname()+" "+"Your Booking Id :"+booking.getBookingId()+" "+"Booking Date :"+booking.getBookingDate()+" "+" you can check your booking status with the help of BookingID ");//text inmail
		
		sender.send(message);
		map.addAttribute("email_msg","email sent successfully");
		return "ok";
	}
	
}
