<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE HTML>
<head>
<title>M&T Gas Agency</title>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href='<spring:url value="/images/hplogo.jpg"></spring:url>'/>

<link rel="stylesheet" href='<spring:url value="/css/style.css"></spring:url>'  type="text/css" media="all"/>
<link href='http://fonts.googleapis.com/css?family=Duru+Sans' rel='stylesheet' type='text/css'>

</head>





<body>
<div class="wrap">
<div class="header">
<div class="header_top">
<div class="logo">
<!-- <a href="#"><img src="images/hplogo.jpg" alt="" /></a> -->
<img src='<spring:url value="/images/hplogo.jpg"></spring:url>' alt="" /> 
</div>
<div class="menu">
	<ul>
	
	<li><a href="#">About HP</a></li>
 	<li><a href='<spring:url value="/index/abouthp"></spring:url>'>About M&T</a></li>
    <li><a href='<spring:url value="/index/services"></spring:url>'>Sells & Services</a></li>
	<li><a href="#">Feedback</a></li>    	
	<li><a href='<spring:url value="/index/contact"></spring:url>'>Contacts</a></li>
    	<div class="clear"></div>
    </ul>
    
 </div>
<div class="clear"></div>
</div>
<div class="header_bottom">
<div class="side_nav">
	<ul>
    	<li><a href='<spring:url value="/cust/register"></spring:url>'>New Customer</a></li>
        <li><a href='<spring:url value="/cust/customerlogin"></spring:url>'>Customer Login</a></li>
    	
  </ul>
</div>
	<div class="header_bottom_img">
		<!-- <img src="images/header_bottom_img.jpg" alt="" /> -->
		 <img src='<spring:url value="/images/header_bottom_img.jpg"></spring:url>' alt="" /> 
	</div>
<div class="clear"></div>
</div>
</div>
<div class="main">
	<div class="sidebar">
		<div class="sidebar_top">
			<h2>MAY<span> I HELP YOU</span></h2>
		</div>
	<div class="sidebar_list">
		<ul>
	    	<!--<li><a href="#">DISTRIBUTOR LOGIN</a></li>-->
	    	<li><a href='<spring:url value="/admin/login"></spring:url>'>ADMIN LOGIN</a></li>
	    	
	    </ul>
	</div>
	<!--<div class="side_form">
		<form>
			<input type="text" value="City"><input type="text" value="State">
			<p>or</p>
			<input type="text" value="PIN CODE"><input type="submit" value="Submit">
		</form>
	</div>-->
	<div class="side_bottom_list">
		<ul>
	    	<!--<li><a href="#">More Options</a></li>-->
	    	<li><a href="#">Map Search</a></li>
	    </ul>
	</div>
	</div>
<div class="content">
	<div class="content_top">
		<div class="content_top_img">
			<img src="images/hpgaslog.png" alt="" />
		</div>
		<div class="content_top_data">
			<h2>WELCOME TO <span>M & T<span> GAS AGENCY</h2>
			<h3>There are many passages of Lorem Ipsum available</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
		</div>
	<div class="clear"></div>
	</div>
	<div class="content_bottom">
		
		<div class="more">
			<p>more <img src="images/more.png" alt="" /></p>
		</div>

		<!--<div class="grides">
			<div class="grid1">
				<img src="images/img_featured1.jpg" alt="" />
				<div class="grid_top">
					<h4>4 beds</h4>
					<h5>Price <span>$2,50,000</span></h5>
				</div>
			<div class="clear"></div>
				<div class="grid_data">
					<h3>Lorem Ipsum is simply dummy text</h3>-->
					<!--<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.which is the same as saying through shrinking from toil and pain. These cases are perfectly simple.</p>-->
				</div>
			</div>

		<!--<div class="grid2">
		<img src="images/img_featured2.jpg" alt="" />
		<div class="grid_top">
		<h4>6 beds</h4>
		<h5>Price <span>$6,50,000</span></h5>
		</div>
		<div class="clear"></div>
		<div class="grid_data">
		<h3>Lorem Ipsum is simply dummy text</h3>-->
		<!--<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.which is the same as saying through shrinking from toil and pain. These cases are perfectly simple. </p>-->
		</div>
		</div>
		<div class="clear"></div>
		</div>
	</div>
</div>
<div class="clear"></div>
</div>
<div class="footer">
		<div class="footer_nav">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="abouthp.html">About HP</a></li>	
				
				<li><a href="aboutM&T.html">About M&T</a></li>
				<li><a href="services.html">Services</a></li>
				<li><a href="about.html"></a></li>
				<li><a href="feedback.html">Feedback</a></li>
				<li><a href="contact.html">Contacts</a></li>
			</ul>
		
	<div class="clear"></div>
	</div>
</div>
</body>
</html>
