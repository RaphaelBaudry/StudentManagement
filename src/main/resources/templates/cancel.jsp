<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
      <title> Speed </title>
      <meta charset="utf-8">
      <link rel="stylesheet" href="/css/style.css">
<body>
<header>
  <div id="header">
    <h1> Speed </h1>
     <link rel="shortcut icon" href="/faviconCancun.jpg">
  </div>  
</header>
<script type="text/javascript"></script>      
		<form name="Form" method="post">
  			<div class="elem-group">
    			<label name="lastName" for="lastName">Distance</label>
    			<span name="lastName">${lastNameValue}</span>
  			</div>
  			<div class="elem-group">
    			<label name="firstName" for="firstName">Time</label>
    			<span name="firstName">${firsNameValue}</span>
  			</div>
  			<div class="elem-group">
    			<label name="email" for="email">Speed</label>
    			<span name="emailValue">${emailValue}</span>
  			</div>
		</form>
		<div class="elem-group inlined" id="center">
  			<button  onclick="history.go(-1)">Return</button>
  		</div>
</body>
</html>