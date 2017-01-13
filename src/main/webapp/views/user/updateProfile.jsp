<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="css/registr.css">

<form:form action="updateProfile" method="post" class="module" 
onsubmit="if(!this.password.value) return false">

    <input type="text" name="name" value="${user.name}">
    <input type="email" name="email" value="${user.email}">
    <input type="text" name="phone" value="${user.phone}">
    <input type="password" name="password" placeholder="Password">
    <button class="btn btn-block btn-primary">save updates</button>
</form:form>


