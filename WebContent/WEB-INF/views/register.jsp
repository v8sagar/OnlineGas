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
    	<li><a href="#">New Customer</a></li>
        <li><a href="customerlogin">Customer Login</a></li>
    	
  </ul>
</div>
<div class="feedback">
	<div class="feed">
	  <h1>Register Here<br>
	  ${requestScope.massage}
	  </h1>

  <form:form onsubmit="return FormValidation();" method="post" modelAttribute="customer">
	 
	         <label>First Name</label>
		    <form:input id="firstname"  type="text" value="${requestScope.firstname}" path="firstname"/>
		   
		       <label>Last Name</label>
		    <form:input id="lastname" value="${requestScope.lastname}" path="lastname"/>
		
		    
		      <label>
				<span>Gender </span>
				<span>
				  
				  <lable> <form:radiobutton id="gender" path="gender" value="Male"/>Male</lable>
				</span>
				<span>
				  
				  <lable> <form:radiobutton id="gender" path="gender" value="Female"/>Female</lable>
				</span>
			
			</label>
		 
		   <label>Birth Date(mm/dd/yyyy)</label>
		    <form:input id="dob"  value="" placeholder="month/day/year" path="dob"/>
		 
		 
		    <label>Address</label>
		   <form:textarea id="address" path="address" />
		 
		    
		   <label id="cityList">
				<span>City</span>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				
					 <form:select  id="cityName" path="city.cityName">
	                    <form:option value="0" label="--Select--"/>
	                      <form:options items="${requestScope.li+st_city}"/>
	   
	            </form:select>
	       </label>
		 

		    <label>Mobile No [0-9]</label>
		    <form:input pattern="[0-9]{10}" id="mobileno" type="text" value="${requestScope.mobileno}" path="mobileno"/>
        

		    <label>Email</label>
		    <form:input id="email" type="text" value="${requestScope.email}" path="email"/>
		    
		    
		      <label>Password</label>
		    <form:password id="password" path="password" />
		   
		   
		   
		   
		   <label id="cityList">
				<span>Connection Type</span>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				
					 <form:select id="connectiontype" path="connectiontype">
	                   <form:option value="0" label="--Select--"/>  
	                      <form:options items="${requestScope.list_contype}"/>
	   
	            </form:select>
	       </label>
		  		 
		   <label id="cityList">
		    <span>User Type</span>
		        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		
			     <form:select path="usertype">
		     <form:option value="0" label="--Select--"/>
		     <form:options items="${requestScope.list_usertype}"/>
		   
		      </form:select>
		   </label>   

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
		 
		   
		   <!-- <label><a href="rigistration.html">Register here</a></label>-->
		   <input type="submit" value="Submit">
	    
	  </form:form>
	<script src="js/jquery.js"></script>
	<script src="<spring:url value='/js/jquery.js'></spring:url>"></script>
	    <script>
			function FormValidation()
			{
				var firstname=$('#firstname').val();
				var lastname=$('#lastname').val();
				//gender
				var gender=$('#gender').val();
				var dob=$('#dob').val();
				var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;


				var address=$('#address').val();
				var cityName=$('#cityName').val();
				var mobileno=$('#mobileno').val();
				var email=$('#email').val();
				var password=$('#password').val();
				var securityAns=$('#securityAns').val();
				console.log("gender value   "+gender);

               /*
               
               var dob = $(dob).val();
    var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
    if (!(date_regex.test(dob))) {
    alert("Date Must Be in mm/dd/yyyy format");
               
               */

				if(firstname.length == 0)
				{
					alert('Enter First Name ');
					return false;
				}
				else if(firstname >= 0)
				{
					alert('Alphabetical caracter required in First Name');
					return false;
				}
				else if(lastname.length == 0)
				{
					alert('Enter Last Name');
					return false;
				}
				else if(lastname >= 0)
				{
					alert('Alphabetical caracter required in Last Name');
					return false;
				}
				else if(gender.length == 0)
				{
					alert('Select Genger');
					return false;
				}

				else if(dob.length == 0)
				{
					alert('Enter Date of Birth');
					return false;
				}
				else if(!(date_regex.test(dob)))
			    {
					alert("Date Must Be in mm/dd/yyyy format");
					return false;
			    }
				
				else if(address.length == 0)
				{
					alert('Enter enter address');
					return false;
				}
				else if(address >= 0)
				{
					alert('Alphabetical caracter required in Address');
					return false;
				}
				//////////////
				else if(cityName == "")
				{
					alert('Select city');
					return false;
				}
				else if(mobileno.length == 0)
				{
					alert('Enter mobile no');
					return false;
				}
				else if(email.length == 0)
				{
					alert('Enter email Id');
					return false;
				}
				else if(password.length == 0)
				{
					alert('Enter Password');
					return false;
				}
				else if(password.length < 3)
				{
					alert('Too Short Password');
					return false;
				}
				else if(securityAns.length == 0)
				{
					alert('Enter Security Ans');
					return false;
				}
				else if(securityAns >= 0)
				{
					alert('Alphabetical caracter required in Security Ans');
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