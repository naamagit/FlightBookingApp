<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Find Flights</title>
</head>
<body>
<h2>Find Flights</h2>
<form action="findFlights" method="post">
From: <input type="text" name="from"/>
To: <input type="text" name="to"/>
Departure Date: <input type="text" name="departureDate"/>
<input type="submit" value="search"/>
</form>
</body>
</html>