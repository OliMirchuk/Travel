<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="css/loginpage.css">


<div class="login">
	<h1>Login</h1>
    <form:form action="loginprocesing" method="post">
    	<input type="text" name="username" placeholder="User name"  />
        <input type="password" name="password" placeholder="Password" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form:form>
</div>