package com.naama.flightreservation.integration;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naama.flightreservation.integration.dto.Reservation;
import com.naama.flightreservation.integration.dto.ReservationUpdateRequest;

@RestController
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		// call the flight reservation service.
		Reservation reservation = restTemplate.
				getForObject(RESERVATION_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return null;
	}

}
