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
<hr>
No news available
</body>
</html>