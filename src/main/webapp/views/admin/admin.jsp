<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<script src="js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="css/admin.css">
    
    
    <nav class="navbar navbar-default navbar-fixed-top">
	<ul class="topnav">
  	<li><a href="home">Home</a></li>
  	<li><a href="aboutus">About</a></li>
	<li><a href="contact">Contact</a></li>
	<li class ='logot'></li>
  	


<div class='logout'>
<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</div>

	</ul>
</nav>
    
<section class='menu'>
  <nav class="btn-bar nav-light">
    <a href="newCountry" class="btn btn-glass">
      New Country
    </a>
    <a href="newCity" class="btn btn-glass btn-primary">
      <i class="fa fa-fw fa-lg fa-chevron-right"></i> New City
    </a>
    <a href="newHotel" class="btn btn-glass btn-success">
      <i class="fa fa-fw fa-lg fa-check"></i> New Hotel
    </a>
    <a href="newRoom" class="btn btn-glass btn-warning">
      <i class="fa fa-fw fa-lg fa-exclamation "></i> New Room
    </a>
    <a href="newTravel" class="btn btn-glass btn-danger">
      <i class="fa fa-fw fa-lg fa-times"></i> New Travel
    </a>
  </nav>
</section>




	
