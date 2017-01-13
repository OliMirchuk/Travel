<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/travel.css">

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
<form:form modelAttribute="travel" action="saveTravel" method="post" class="form-wrapper">
	<form:select path="country" items="${countriesDTOs}" itemLabel="countryName" itemValue="id" id="idCountry">
	</form:select>
	<form:select path="city" items="${citiesDTOs}" itemLabel="cityName" itemValue="id" id="idCity">
	</form:select>
	<form:select path="hotel" items="${hotelsDTOs}" itemLabel="hotelName" itemValue="id" id="idHotel">
	</form:select>
	<br>
	<br>
	<form:select path="room" items="${roomsDTOs}" itemLabel="number_room" itemValue="id" id="idRoom">
	</form:select>
	<form:input path="days_trip"  type="text" placeholder="days trip"/>
	<select name="type_traffic" id="type_traffic">
			<option>type_traffic</option>				
				<option>bus</option>
				<option>airplane</option>
				<option>cruise ship</option>
		</select>

	<form:input path="cost_travel"  type="text" placeholder="cost travel"/>
	<br>
	<br>
	<input name="date" id="date" type="date" placeholder="day start">
	<input type="submit" value="save" id="submit">

</form:form>
<div id='all'>
<c:forEach var="travel" items="${travels}">
		${travel.country.countryName}  ${travel.city.cityName}  ${travel.hotel.hotelName}  ${travel.hotel.stars}*  ${travel.days_trip}  ${travel.type_traffic}  ${travel.day_start}  ${travel.cost_travel}$  
		<a class='del' href="deleteTravel/${travel.id}">delete travel</a>
		<br>
	</c:forEach>
</div>