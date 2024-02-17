<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
      <title>Speed</title>
      <meta charset="utf-8">
      <link rel="stylesheet" href="/css/style.css">
<body>
<header>
  <div id="header">
    <h1> Speed </h1>
    <title> Speed </title>
    <link rel="shortcut icon" href="/faviconCancun.jpg">
  </div>
</header>
		<form name="Form" action="/Speed" method="post" lang="en">
  			<div class="elem-group">
    			<label for="distance">Distance</label>
    			<input type="text" id="distance" name="distance" placeholder="Distance" 
    			pattern=[A-Z\sa-z]{3,20} lang="en"  
    			oninvalid="alert('Please insert the distance')" required>
  			</div>
  			<div class="elem-group">
    			<label for="time">Time</label>
    			<input type="text" id="time" name="time" placeholder="Time" 
    			pattern=[A-Z\sa-z]{3,20} 
    			oninvalid="alert('Please insert the time')" required>
  			</div>
  			<div class="elem-group">
    			<input type="text" id="speed" name="speed" placeholder="Speed" 
    			oninvalid="alert('Please insert the speed')" required>
  			</div>
  				<div class="elem-group">
  				</div>
  				<div id="center">
  				<hr>
  					<button type="submit">Book a reservation</button>
  					<hr>
    				<button type="submit" name="camper" formaction="modifyTheReservation">Modify a reservation</button>
    				
    				<button type="submit" name="camper" action="/Speed/cancelTheReservation">Cancel a reservation</button>
    			</div>
		</form>
</body>
</html>