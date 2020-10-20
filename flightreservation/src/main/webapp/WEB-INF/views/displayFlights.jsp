<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Flights</title>
</head>
<body>
<h2>Flights:</h2>
<table>
<tr>
<th>Airlines</th>
<th>Departure City</th>
<th>arrivalCity</th>
<th>Departure Time</th>
</tr>
<tr>
<c:forEach items="${flights}" var="flight">
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.estimatedDepartureTime}</td>
<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>