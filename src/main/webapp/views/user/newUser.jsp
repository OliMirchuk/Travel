<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="css/registr.css">
	
<%-- <c:forEach var="userDTO" items="${userDTOs}">
		<div style="background-color: aqua">
			${userDTO.name} ${userDTO.email} <a href="deleteUser/${userDTO.id}">delete</a>
		</div>
		<br>
	</c:forEach> --%>


  <form:form modelAttribute="user" action="saveUser" method="post">
		<div class="body-content">
			<div class="module">
			 <h1>Welcome</h1>
			 <h1>Create an account</h1>
				<form class="form" id="form1">

					<p class="name">
					<label for="Name">${usernameException}</label>
						<form:input path="name" type="text"
							class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
						 placeholder="Login" id="name" />
					</p>

					<p class="password">
					<label for="Name">${passwordException}</label>
						<form:input path="password" type="password"
							class="validate[required,custom[email]] feedback-input"
							id="password" placeholder="Password" />
					</p>
					<p class="email">
					<label for="Name">${emailException}</label>
						<form:input path="email" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="phone">
					<label for="Name">${phoneException}</label>
						<form:input path="phone" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="phone" placeholder="Phone" />
					</p>
<input type="submit" value="SEND" name="register" class="btn btn-block btn-primary" />
					
				</form>
			</div> 
	</form:form>

	