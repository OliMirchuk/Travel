<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/aboutus.css">
<script src="js/jquery-3.1.1.min.js"></script>




<nav class="navbar navbar-default navbar-fixed-top">
	<ul class="topnav">
  	<li><a href="home">Home</a></li>
  	<li><a href="aboutus">About</a></li>
	<li><a href="contact">Contact</a></li>
	<li class ='logot'></li>
 <sec:authorize access="isAuthenticated()"> 	 	
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="right"><a href="admin">main menu</a></li>
</sec:authorize>

<div class='logout'>
<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</div>
</sec:authorize>
	</ul>
</nav>
</div>
		
			<img src="http://www.love-tur.com/images/licenziya.jpg" align="left" class="hover" />
 <div class='text'>   	
    <h1>About us</h1>	
<h2>Our destinations</h2>

<p>Leisure at sea</p>
<p>Ski tours</p>
<p>Bus tours</p>
<p>Air tour</p>
<p>Stays in his car</p>
<p>Health resorts, thermal spas, the SPA</p>
<p>Rest on the lakes</p>
<p>Diving</p>
<p>Pilgrimage tours</p>
<p>Children rest</p>
<p>Wedding and romantic tours</p>
<p>River cruises</p>
<p>Bicycle tours</p>
<p>Exotic tours</p>
<p>Education abroad</p>
<p>Business (exhibitions, conferences, seminars)</p>
<p>Cheap tours</p>
<h2>Additional services</h2>
<p>Flights</p>
</div>


