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
<link rel="shortcut icon" href='<spring:url value="/images/hplogo.jpg"></spring:url>'/>
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
	<li><a href="abouthp.html">About HP</a></li>
 	<li><a href="aboutM&T.html">About M&T</a></li>
      	<li><a href="services.html">Sells & Services</a></li>
	<li><a href="feedback.html">Feedback</a></li>    	
	<li><a href="contact.html">Contacts</a></li>
    	<div class="clear"></div>
    </ul>
    
 </div>

<div class="clear"></div>
</div>
<!--<div class="header_bottom">-->
<div class="side_nav">
		<ul>
    	<li><a href="#">Stock</a></li>
        <li><a href="listofrequest">Registration Request</a></li>
    	<li><a href="listofbookingrequest">Booking Request</a></li>
    	<li><a href="#">View FeedBack</a></li>
    	<li><a href="logout">Logout</a></li>
  
  </ul>
</div>
<div class="feedback">
	<div class="feed">
	  <h1>Welcome, ${sessionScope.msg.firstname} 
	  <br/>${requestScope.sms}
	              ${sessionScope.stock_msg}</h1>
	 
	 
	 
	  <form:form onsubmit="return FormValidation();" method="post" modelAttribute="stockdetail">
	  
	     <form>
	        <label></label>
		    <label>Date (dd/mm/yyyy)</label>
		    <form:input id="date" type="text" value="${requestScope.date}" path="date" readonly="true"/>
		    
		
		    <label>Commercial</label>
		    <form:input id="consumer" type="text" value="" path="consumer"/>
		    
		    <label>Domastic</label>
		    <form:input id="domestic" type="text" value="" path="domestic"/>

		   <!-- <label><a href="rigistration.html">Register here</a></label>-->
		   <input type="submit" value="Submit">
		  
		   <label><a href="<spring:url value='/admin/showstock'/>">See Previous Stock</a></label>
	    
	    </form>
	
	  
	  
	  </form:form>
	  <script src="js/jquery.js"></script>
	<script src="<spring:url value='/js/jquery.js'></spring:url>"></script>
	    <script>
			function FormValidation()
			{
			//	var date=$('#date').val();
				//var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
				var consumer=$('#consumer').val();
				var domestic=$('#domestic').val();
               /*
               var dob = $(dob).val();
    var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
    if (!(date_regex.test(dob))) {
    alert("Date Must Be in mm/dd/yyyy format");
               
               */

			/*	if(!(date_regex.test(date)))
			    {
					alert("Date Must Be in mm/dd/yyyy format");
					return false;
			    }*/
				if(consumer.length == 0)
				{
					alert('Enter Cumersial stock ');
					return false;
				}
				else if(domestic.length == 0)
				{
					alert('Enter Domastic stock ');
					return false;
				}
					return true;
			}
		</script>

	    <div class="clear"></div>
	</div>
</div>

</body>
</html>