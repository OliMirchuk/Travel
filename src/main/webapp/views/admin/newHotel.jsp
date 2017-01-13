<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="css/hotel.css">
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
	<input type="text" id="hotelName" placeholder="hotel name"/>
	<select  id="stars">
			<option> stars</option>				
				<option>3</option>
				<option>4</option>
				<option>5</option>
		</select>
<select  id="food">
			<option>type of food</option>				
				<option>BB</option>
				<option>HB</option>
				<option>AI</option>
		</select >
<select id="idCity">
    <c:forEach var="city" items="${citiesDTOs}">
        <option value="${city.id}">${city.cityName}</option>
    </c:forEach>
</select>
<br>
<br>

<button id="submit">save hotel</button>

</div>
<div id="all"></div>



	<%-- <c:forEach var="hotel" items="${hotels}">
		${hotel.hotelName} ${hotel.stars}${hotel.type_of_food}
		<a href="deleteHotel/${hotel.id}">delete hotel</a>
		<br>
	</c:forEach> --%>



<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="js/hotel.js"></script>

