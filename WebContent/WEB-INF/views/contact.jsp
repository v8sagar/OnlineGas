<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE HTML>
<head>
<title>M&T Gas Agency</title>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link rel="stylesheet" href='<spring:url value="/css/style.css"></spring:url>'  type="text/css" media="all"/>
<link href='http://fonts.googleapis.com/css?family=Duru+Sans' rel='stylesheet' type='text/css'>

</head>

<body>
<div class="wrap">
<div class="header">
<div class="header_top">
<div class="logo">
<a href="index.html"><img src="images/hplogo.jpg" alt="" /></a>
<img src='<spring:url value="/images/hplogo.jpg"></spring:url>' alt="" /> 
</div>
<div class="menu">
	<ul>
	
		<li><a href='<spring:url value="/index/home"></spring:url>'>About HP</a></li>
 	<li><a href='<spring:url value="/index/abouthp"></spring:url>'>About M&T</a></li>
      	<li><a href='<spring:url value="/index/services"></spring:url>'>Sells & Services</a></li>
	<li><a href="#">Feedback</a></li>    	
	<li><a href="#">Contacts</a></li>
    </ul>
</div>
<div class="clear"></div>
</div>
<div class="header_bottom">
<div class="side_nav">

<!--
  </div>
	<div class="header_bottom_img">
		<img src="images/header_bottom_img.jpg" alt="" />
		<img src='<spring:url value="/images/header_bottom_img.jpg"></spring:url>' alt="" />
	</div>  -->
<div class="clear"></div>
</div>
</div>

<div class="feedback">
	<div class="feed">
	  <h1>CONTACT</h1>
	  <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p>
	
	     <div class="company_address">
	     	<h2>M&T Gas Agency :</h2>
		    <p>500 Lorem Ipsum Dolor Sit,</p>
		   <p>22-56-2-9 Sit Amet, Lorem,</p>
		   <p>India</p>
		   <div class="address_data">
		   <p>Phone:(00) 222 666 444<p>
		   <p>Fax: (000) 000 00 00 0<p>
		   <p>Website:<a href="#"> www.m&tgas.com</a><p>
		  <p> Email:<a href="#">info@m&tgas.com</a><p>
		   <p>Follow on <a href="#">Facebook</a><p>
	   	</div>
	    </div>
	    <div class="clear"></div>
	</div>
</div>
<div class="clear"></div>
</div>
<div class="footer">
		<div class="footer_nav">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="about.html">About M&T</a></li>
				<li><a href="services.html">Services</a></li>
	
				<li><a href="feedback.html">Feedback</a></li>
				<li><a href="contact.html">Contacts</a></li>
			</ul>
		</div>
	<div class="clear"></div>
	</div>
</div>
</body>
</html>
