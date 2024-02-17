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
     <link rel="shortcut icon" href="/pay.jsp">
  </div>  
</header>
<script type="text/javascript"></script>      
		<form name="Form" action="main" method="post">
  			<div class="elem-group">
    			<label for="lastName">Distance</label>
    			<span name="distanceValue">${distanceValue}</span>
  			</div>
  			<div class="elem-group">
    			<label for="time">Time</label>
    			<span name="timeValue">${timeValue}</span>
  			</div>
  			<div class="elem-group">
    			<label for="speed">Speed</label>
    			<span name="speedValue">${speedValue}</span>
  			</div>
  				<div id="center">
  					<button type="submit">Return to the Main Page</button>
  				</div>
		</form>
</body>
</html>