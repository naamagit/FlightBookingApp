package com.naama.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naama.flightreservation.dto.ReservationRequest;
import com.naama.flightreservation.entities.Flight;
import com.naama.flightreservation.entities.Passenger;
import com.naama.flightreservation.entities.Reservation;
import com.naama.flightreservation.repos.FlightRepository;
import com.naama.flightreservation.repos.PassengerRepository;
import com.naama.flightreservation.repos.ReservationRepository;
import com.naama.flightreservation.util.EmailUtil;
import com.naama.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:/java/reservations/reservation"+savedReservation.getId()+".pdf";
		
		
		pdfGenerator.generateItinerary(savedReservation,
				filePath);
		//emailUtil.sentItinerary(passenger.getEmail(), filePath);
		

		return savedReservation;
	}

}
