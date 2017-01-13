<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="css/profile.css">
<%-- <form:form action="back" method="post">
		<button>back</button>
	</form:form>
<br>
${user.name} ${user.email} ${user.phone}
<a href="updateProfile">update profile</a>
<br>

<br>
<img src="${user.pathImage}" alt="add foto" width="200px" height="200px">
<br>

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <button>save image</button>
</form:form>
<br> --%>


<div class="content-profile-page">
   <div class="profile-user-page card">
      <div class="img-user-profile">
        <img class="profile-bgHome" src="http://knig.org.ua/wp-content/uploads/2013/04/globe_book_travel.jpg" />
        
<img  class="avatar" src="${user.pathImage}" alt="add foto">
<br>

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data"
           onsubmit="if(!this.image.value) return false">
    <input type="file" name="image">
    <button>save image</button>
</form:form>
<br>
           </div>
          <form:form action="back" method="post">
		<button class='back'>Back</button>
	</form:form>
          <div class="user-profile-data">
            <h1>${user.name}</h1>
            <p> ${user.email}</p>
            <p> ${user.phone}</p>
            <a href="updateProfile">update profile</a>
          </div> 
<c:forEach var="travel" items="${travels}">
		${travel.country.countryName}  ${travel.city.cityName} "${travel.hotel.hotelName}" ${travel.hotel.stars}* ${travel.hotel.type_of_food}, start ${travel.day_start}, night ${travel.days_trip}cost ${travel.cost_travel}$ 
			<a href="deleteFromOrder/${travel.id}">delete</a>
    		<a href="getOrder/${travel.id}">get order</a>
			<br>
</c:forEach>
        <!--  <div class="description-profile">Front-end | Security Researcher | CSS Warrior | <a href="https://twitter.com/bullgit" title="bullgit"><strong>@bullgit</strong></a> | I love to create small things for the internet!</div>
        <ul class="data-user">
        <li><a><strong>3390</strong><span>Posts</span></a></li>
        <li><a><strong>718</strong><span>Followers</span></a></li>
        <li><a><strong>239</strong><span>Following</span></a></li>
       </ul>
<footer>
   <h4>Design by <a href="https://twitter.com/jofpin" target="_blank" title="José Pino">@jofpin</a></h4>
</footer> -->
      </div>
    </div>

