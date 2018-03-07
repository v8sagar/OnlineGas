package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomeCotroller
{
    @RequestMapping("/home")
    public String home()
    {
    	System.out.println("in side home");
    	return "home";
    }
    @RequestMapping("/abouthp")
    public String abouthp()
    {
    	System.out.println("in side abouthp");
    	return "abouthp";
    }
    @RequestMapping("/services")
    public String sevices()
    {
    	System.out.println("in side abouthp");
    	return "services";
    }
    @RequestMapping("/contact")
    public String contact()
    {
    	System.out.println("in side abouthp");
    	return "contact";
    }
}
