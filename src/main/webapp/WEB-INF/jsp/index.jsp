<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{skeleton}"
      xmlns:th="http://www.thymeleaf.org">
      <title> The Students </title>
      <meta charset="utf-8">
      <link rel="stylesheet" href="/css/style.css">
      <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<header>
  <div id="header">
    <h1> The Students </h1>
     <link rel="shortcut icon" href="/jsp/icons8-favicon-50.png">
  </div>  
</header>
 <div class="topnav">
  <a href="/StudentManagement/home">Home</a>
  <a href="/StudentManagement/news">News</a>
  <a href="/StudentManagement/contacts">Contact</a>
  <a href="/StudentManagement/help" class="split">Help</a>
</div> 
<br>
 <div class="container">

  <form name="Form" action="/StudentManagement/listDatabases" method="get" lang="en" id="center">
<br>

</form>
<br>
<form name="Form" action="/StudentManagement/okay" method="get" lang="en" id="center">

<select name="visitor_option_database">
  <option value="">--Please choose a database--</option>
  <c:forEach var="database" items="${databases}">
    <option  value="${database}" default="Not Available">${database}</option>
</c:forEach>
</select>
 <br>
 <br>
	<button type="submit" name="camper" formaction="/StudentManagement/okay">OKAY</button>
</form>
 
 <form name="Form" action="/StudentManagement/fillPerson" method="get" lang="en" onsubmit="return !!(validateEmail() & checkAge());">
	<div class="elem-group">
    			<label for="distance">Firstname</label>
    			<input type="text" id="name" name="visitor_firstname" placeholder="Firstname" lang="en"  
    			 required>
  			</div>
  			<div class="elem-group">
    			<label for="distance">Lastname</label>
    			<input type="text" id="name" name="visitor_lastname" placeholder="Lastname" lang="en"  
    			required>
  			</div>
  			<div class="elem-group">
    			<label for="distance">Email</label>
    			<input type="text" id="email" name="visitor_email" placeholder="Email" lang="en"  
    			required>
  			</div>
  			
  			<script>
    			function validateEmail() {
       			var email = document.getElementById("email").value;
        		var regex = /^[A-Za-z0-9+_.-]+@(.+)$/;
        		if (regex.test(email)) {
					return true;
        			} else {
            		alert("Invalid email address.");
            		return false;        			
            		}
   				}
    			
    			</script>
			
  			<div class="elem-group">
    			<label for="distance">Age</label>
    			<input type="text" id="age" name="visitor_age" placeholder="Age" lang="en"  
    			 min="10" max="100" required>
  			</div>
  			
  			<script>
  			function checkAge() {
       			var age = document.getElementById("age").value;
        		var regex = /^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$/;
        		if (regex.test(age)) {
        			return true;
        			} else {
        				alert("Age must be a number < 200");
        				return false;
        			}
   				}
  			
  			</script>
			
  			<div class="elem-group inlined" id="center">
				<button type="submit" name="camper" formaction="/StudentManagement/fillPerson">Add Person</button>
			</div>
		</form>
		
        <div class="row">
        <form method="get" action="/StudentManagement/listPersons">
			<div class="elem-group inlined" id="center">
				<button type="submit" name="camper" formaction="/StudentManagement/listPersons">Display Persons >></button>
			</div>
		</form>
       </div>
<tbody>

</tbody>
</body>
</html>