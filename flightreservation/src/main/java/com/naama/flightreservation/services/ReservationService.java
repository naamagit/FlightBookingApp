package com.naama.flightreservation.services;

import com.naama.flightreservation.dto.ReservationRequest;
import com.naama.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
