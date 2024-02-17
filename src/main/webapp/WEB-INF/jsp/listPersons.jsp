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
  <a href="/StudentManagement/help">Help</a>
</div> 
 <div class="container">			
        <div class="row">
       </div>
       <form method="get" action="/StudentManagement">
			<div class="elem-group inlined" id="center">
				<button type="submit" name="camper" formaction="/StudentManagement"><< Return</button>
			</div>
		</form>
       <form method="get" action="/StudentManagement/removeAll">
			<div class="elem-group inlined" id="center">
				<button type="submit" name="camper" formaction="/StudentManagement/removeAll" onclick="return remove();">Remove All</button>
			</div>
		</form>
		
<tbody>

<div class="elem-group inlined" id="center">
<table id="tablea" id="center">
<tr><td>  Firstname  </td><td>  LastName  </td><td>  Age  </td><td>  Email  </td></tr>
<c:forEach items="${personnes}" var="personne"  varStatus="loop">
    <form method="get" action="/StudentManagement/remove">
    <tr><td><c:out value="${personne.firstname}" default="Not Available" escapeXml="false"></c:out></td>
    <td><c:out value="${personne.lastname}" default="Not Available" escapeXml="false"></c:out></td>
    <td><c:out value="${personne.age}" default="Not Available" escapeXml="false"></c:out></td>
    <td><c:out value="${personne.email}" default="Not Available" escapeXml="false"></c:out></td>
        <td>

<input type="hidden" name="index" value="${loop.index})">
<script>
        function remove() {
        	if (confirm("Do you really want to remove ?")) {
        		return true;
        	} return false;
        }
        </script>
        	<button id="reset" type="submit" name="camper" onclick="return remove();" formaction="/StudentManagement/remove"></button>
    </td></tr>
    </form>
  </c:forEach>
</table>

</div>
</tbody>
</body>
</html>