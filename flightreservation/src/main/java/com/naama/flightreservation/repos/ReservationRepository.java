package com.naama.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naama.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
