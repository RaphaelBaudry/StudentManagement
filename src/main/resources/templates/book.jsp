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
    			<label name="distance" for="distance">Distance</label> 
    			<span name="distanceValue">${distanceValue}</span>
  			</div>
  			<div class="elem-group">
    			<label name="time" for="time">Time</label> 
    			<span name="timeValue">${timeValue}</span>
  			</div>
  			<div class="elem-group">
    			<label name="speed" for="speed">Speed</label> 
    			<span name="emailValue" value=${distanceValue}/${timeValue}></span>
  			</div>
		</form>
		<div class="elem-group inlined" id="center">
  			<button  onclick="history.go(-1)">Return</button>
  		</div>
		<form method="post" onsubmit="return confirm('Do you really want to confirm the payment ?');">
			<div class="elem-group inlined" id="center">
				<button type="submit" name="camper" formaction="payTheReservation">Confirm</button>
			</div>
		</form>
		
</body>
</html>