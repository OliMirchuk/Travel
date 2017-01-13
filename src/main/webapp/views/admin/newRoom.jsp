<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/room.css">
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
<input  id='number_room' placeholder="number room"/>
<input  id='floor' placeholder="floor"/>
<input  id='number_of_people' placeholder="number of people"/>	
<select  id="room_type">
			<option> room type</option>				
				<option>standart</option>
				<option>suite</option>
				<option>suite senior</option>
				<option>suite mini</option>
				<option>family studio</option>
				<option>family room</option>
				<option>duplex</option>
				<option>luxe</option>
				<option>business</option>
				<option>superior</option>
				<option>honeymoon room</option>
				<option>president</option>
		</select >
		<br>
		<br>
<select id="idHotels">
    <c:forEach var="hotel" items="${hotelsDTOs}">
        <option value="${hotel.id}">${hotel.hotelName}</option>
    </c:forEach>
</select>

<button id="submit">save room</button>
</div>
<div id="all"></div>

<%-- <c:forEach var="room" items="${rooms}">
	
		${room.number_room} ${room.floor} ${room.number_of_people} ${room.room_type} 
		<a href="deleteRoom/${room.id}">delete</a>

	<br>
</c:forEach> --%>

<%-- <form:form modelAttribute="room" action="saveRoom" method="post" class="form-wrapper">
	
	<form:input path="number_room" type="text" placeholder="number room" id="stars"/>
	<form:input path="floor" type="text" placeholder="number floor" id="stars"/>
	<form:input path="number_of_people" type="text" placeholder="number of people" id="stars"/>
	<select name="room_type" id="room_type" >
			<option> room type</option>				
				<option>standart</option>
				<option>suite</option>
				<option>suite senior</option>
				<option>suite mini</option>
				<option>family studio</option>
				<option>family room</option>
				<option>duplex</option>
				<option>luxe</option>
				<option>business</option>
				<option>superior</option>
				<option>honeymoon room</option>
				<option>president</option>
			
		</select>
<br>
<br>
	<form:select path="hotel" items="${hotels}" itemLabel="hotelName" itemValue="id" id="hotelName" >
	</form:select>
	<input type="submit" value="save room" id="submit">
</form:form> --%>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="js/room.js"></script>

