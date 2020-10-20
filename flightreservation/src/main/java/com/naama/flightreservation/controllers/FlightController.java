package com.naama.flightreservation.controllers;

import java.util.List;

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

	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") String departureDateString, ModelMap modelMap) {

		String departureDate = departureDateString;

		System.out.println(departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);

		return "displayFlights";
	}

}
