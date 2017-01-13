<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/contact.css">
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


<div class='contacts'>
<h2>Contacts</h2>
<h3>E-mail:</h3> <p>info@love-tur.com</p>
<h3>Phone:</h3> <p>(0432) 65 91 19</p>
<h3>Mobile:</h3> <p>(096) 488 60 95, <br>   (063) 189 22 40,<br>
(063) 306 49 82,  <br>  (067) 217 20 89, <br>   (093) 901 54 87</p>
<h3>Viber:</h3> <p>(063) 306 49 82</p>
<h3>Fax:</h3> <p>(0432) 65 91 19</p>
<h3>Hours: </h3> <p>Mon-Fri: 09-19, Sat: 10-17, Sun: by agreement</p>
</div>
