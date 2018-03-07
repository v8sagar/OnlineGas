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
<a href="#"><img src='<spring:url value="/images/hplogo.jpg"></spring:url>' alt="" /></a>
</div>
<div class="menu">
	<ul>
	<li><a href="home">About HP</a></li>
 	<li><a href="#">About M&T</a></li>
    <li><a href='<spring:url value="/index/services"></spring:url>'>Sells & Services</a></li>
	<li><a href="#">Feedback</a></li>    	
	<li><a href='<spring:url value="/index/contact"></spring:url>'>Contacts</a></li>
    	<div class="clear"></div>
    </ul>
    
 </div>
<div class="clear"></div>
</div>


</div>
<div class="content">
	<div class="content_top">
		<div class="content_data">
			<h2>ABOUT M&T </h2>
			<h3>There are many passages of Lorem Ipsum available</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
		</div>
		<div class="content_top_img">
		<img src='<spring:url value="images/about_img_lpg.jpg"></spring:url>' alt="" />
					</div>
	<div class="clear"></div>
	</div>
	<div class="about_data">
		<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
		<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
		<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum.</p>
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
