<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<link rel="stylesheet" href="css/country.css">
<script src="js/jquery-3.1.1.min.js"></script>

 <nav class="navbar navbar-default navbar-fixed-top">
	<ul class="topnav">
  	<li><a href="home">Home</a></li>
  	<li><a href="aboutus">About</a></li>
  	<li><a href="contact">Contact</a></li>
	<li class ='logot'></li>
  	
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="right"><a href="admin">main menu</a></li>
</sec:authorize>

<div class='logout'>
<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</div>

	</ul>
</nav>

<div class="form-wrapper">
   <input type="text" name="countryName" id="countryName" placeholder="country name" required>
   <button id="submit">save</button>
   
</div>
<br/>
<br/>
<br/>
<br/>
<div id="all"></div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="js/country.js"></script>
