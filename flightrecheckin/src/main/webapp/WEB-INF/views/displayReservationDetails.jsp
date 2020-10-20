<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details:</h2>

Airlines: ${reservation.flight.operatingAirlines}<br/>
Flight No: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival City: ${reservation.flight.arrivalCity}<br/>
Date Of Departure: ${reservation.flight.dateOfDeparture}<br/>
Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>

<h2> Passenger Details:</h2>

First Name: ${reservation.passenger.firstName}<br/>
Last Name: ${reservation.passenger.lastName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">

Enter the Number of bags you want to check in:<input type="text" name="numberOfBags"/>
<input type="hidden" value="${reservation.id}" name="reservationId"/>
<input type="submit" value="Check In"/>
</form>

</body>
</html>