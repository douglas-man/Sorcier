package sorcier.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sorcier.Sorcerer;
import sorcier.data.SorcererRepository;

@Controller
@RequestMapping("/sorcerer")
public class SorcererController {
	private SorcererRepository sorcererRepository;
	
	@Autowired
	public SorcererController(
		SorcererRepository sorcererRepository) {
	  this.sorcererRepository = sorcererRepository;
	}
	
	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(Sorcerer sorcerer) {
		sorcererRepository.save(sorcerer);
		
		return "redirect:/sorcerer/"+sorcerer.getUsername();
	}
	
	
}