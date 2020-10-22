package com.naama.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naama.flightreservation.entities.User;
import com.naama.flightreservation.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("INSIDE showRegistrationPage()");
		return "login/registerUser";
	}
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register" + user);
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("showLoginPage");
		return "login/login";
	}
	@RequestMapping(value = "/login", method =RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password")String password,ModelMap modelMap) {

		LOGGER.info("Inside login() and the email is: " + email);

		 User user = userRepository.findByEmail(email);
		 if (user == null) {
			 modelMap.addAttribute("msg", "User name doesn't exists."); 
			 return "login/login";
		 }
		 if (user.getPassword().equals(password)) {
			 return "findFlights";
		 } else {
			 modelMap.addAttribute("msg", "Invalid username or passowrd. Please try again."); 
		 }
		 return "login/login";
	}

}
