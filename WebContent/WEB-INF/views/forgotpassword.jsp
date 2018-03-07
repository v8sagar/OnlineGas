<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>M&T Gas Agency</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<spring:url value="/css/style.css"></spring:url>'  type="text/css" media="all"/>
<link href='http://fonts.googleapis.com/css?family=Duru+Sans' rel='stylesheet' type='text/css'>
</head>

<body>

   <div class="wrap">
 <div class="header">
 <div class="header_top">
<div class="logo">
<a href="#"><img src="images/hplogo.jpg" alt="" /></a>
<a href="#"><img src='<spring:url value="/images/hplogo.jpg"></spring:url>' alt="" /></a>
</div>
<div class="menu">
	<ul>
	
		<li><a href='<spring:url value="/index/home"></spring:url>'>About HP</a></li>
 	<li><a href='<spring:url value="/index/abouthp"></spring:url>'>About M&T</a></li>
      	<li><a href='<spring:url value="/index/services"></spring:url>'>Sells & Services</a></li>
	<li><a href="#">Feedback</a></li>    	
	<li><a href='<spring:url value="/index/contact"></spring:url>'>Contact</a></li>
    </ul>
 </div>

<div class="clear"></div>
</div>
<!--<div class="header_bottom">-->
<div class="side_nav">
	<ul>
    	<li><a href="register">New Customer</a></li>
        <li><a href="#">Customer Login</a></li>
    	<li><a href="#">Book Now</a></li>

  </ul>
</div>
<div class="feedback">
	<div class="feed">
	  <h1>Forgot Password</h1>
	 
	 
	 
	  <form:form method="post" modelAttribute="customer">
	  
	        <label></label>
		    <label>User Email</label>
		    <form:input type="text" value="" path="email"/>
		
		    <label id="cityList">
		    <span>Security Question</span>
		        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		
			     <form:select path="securityQuaston">
		     <form:option value="0" label="--Select--"/>
		     <form:options items="${requestScope.list_qua}"/>
		   
		      </form:select>
		   </label>   
		   
		    <label>Answer</label>
		    <form:input id="securityAns"  type="text" value="" path="securityAns"/>
		 
	
		   <input type="submit" value="Submit">
	
	  </form:form>

	    <div class="clear"></div>
	</div>
</div>

</body>
</html>