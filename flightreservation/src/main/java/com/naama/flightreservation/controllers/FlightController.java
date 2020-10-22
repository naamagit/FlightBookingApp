package com.naama.flightreservation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naama.flightreservation.entities.Flight;
import com.naama.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") String departureDateString, ModelMap modelMap) {

		String departureDate = departureDateString;
		LOGGER.info("Inside findFlights() from " + from + " to " + to + " departureDate " + departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flight Found are " + flights);

		return "displayFlights";
	}

}
