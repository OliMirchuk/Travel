<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/home.css">
<script src="js/jquery-3.1.1.min.js"></script>




<nav class="navbar navbar-default navbar-fixed-top">
	<ul class="topnav">
  	<li><a href="home">Home</a></li>
  	<li><a href="aboutus">About</a></li>
  	<li><a href="#catalogue">Catalogue</a></li>
	<li><a href="contact">Contact</a></li>
	<li class ='logot'></li>
  	<sec:authorize access="!isAuthenticated()">
  <li class="right"><a href="loginpage">Login</a></li>
  <li class="right"><a href="newUser" >Sign Up </a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="right"><a href="admin">admin page</a></li>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<sec:authorize access="!hasRole('ROLE_ADMIN')">
	<li class="right"><a href="profile">profile</a></li>
</sec:authorize>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class='logout'>
<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</div>
</sec:authorize>
	</ul>
</nav>

<!--Home-->

<section id="home">
	<h1>Welcome to <em>Love Travel</em></h1>
	<h3>"Travel brings power and love back into your life."</h3>
	
<br>
<br>

<div id="travels">
<c:forEach var="travel" items="${travels}">
		${travel.country.countryName},   ${travel.city.cityName},  "${travel.hotel.hotelName}" ${travel.hotel.stars}* ${travel.hotel.type_of_food}, start ${travel.day_start}, night ${travel.days_trip} 
		<sec:authorize access="isAuthenticated()">
				cost ${travel.cost_travel}$ 
				<sec:authorize access="!hasRole('ROLE_ADMIN')">
				<a href="buyTravel/${travel.id}">buy</a>
			</sec:authorize>
			</sec:authorize>
		<br>
</c:forEach> 
</div>
<br><br><br>
</section>

<!--Catalogue-->

<section id="catalogue">
		<div class="container-fluid">
		<h1>Catalogue</h1>
		<h3>Hot exclusive offers</h3> 
			
	<div class="row" id="img">
	<div id="wrapper" class="col-md-4">
    <img src="http://dlya-turista.ru/images/statyi/turciya5.jpg" class="hover" />
    <p class="text">Turkey</p>
	</div>
		<div id="wrapper" class="col-md-4">
			<img src="https://discover-ukraine.info/uploads/i/a/516baa33bb5021.72577533.2014.jpg" class="hover" />
    	<p class="text">Ukraine</p>
		</div>
		<div id="wrapper" class="col-md-4">
			<img src="http://sonopath.com/sites/default/files/resize/content-pages/setwidth1700-esd-intro-01-256x178.jpg"  class="hover" />
    	<p class="text">Italy</p>
		</div>
	</div>
</div>
	

</section>

















<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
    
    <script src="js/home.js"></script>   
	