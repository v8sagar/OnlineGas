<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>M&T Gas Agency</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<spring:url value="/css/style.css"></spring:url>'  type="text/css" media="all"/>
<link href='http://fonts.googleapis.com/css?family=Duru+Sans' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href='<spring:url value="/css/bootstrap.min.css"></spring:url>'  type="text/css" media="all"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



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
    	<li><a href="stock">Stock</a></li>
    	<li><a href="logout">Logout</a></li>
  
  </ul>
</div>
<div class="feedback">
	<div class="feed">
	  <h1>Welcome,Admin <br/><br/>
	    Stock Details
	   </h1>
	  
	  <form:form  modelAttribute="stockdetail">
	    <table class="table">
       <thead>
      <tr>
       <th>StockId</th>
       <th>Commercial</th>
        <th>Domestic</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="ac" items="${requestScope.list}">
      <tr>
        <td>${ac.stockId}</td>
        <td>${ac.consumer}</td>
        <td>${ac.domestic}</td>
        <td>${ac.date}</td>
      </tr>
     
    </c:forEach>
    
    </tbody>
  </table> 
	  </form:form>
	    <div class="clear"></div>
	</div>
</div>

</body>
</html>