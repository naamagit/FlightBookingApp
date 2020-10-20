package com.naama.flightreservation.integration;

import com.naama.flightreservation.integration.dto.Reservation;
import com.naama.flightreservation.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
