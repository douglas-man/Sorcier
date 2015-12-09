package sorcier.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sorcier.Sorcerer;
import sorcier.dao.SorcererDao;

@Controller
@RequestMapping("/sorcerer")
public class SorcererController {
	private SorcererDao sorcererDao;
	
	@Autowired
	public SorcererController(
		SorcererDao sorcererDao) {
	  this.sorcererDao = sorcererDao;
	}
	
	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(Sorcerer sorcerer) {
		sorcererDao.save(sorcerer);
		
		return "redirect:/sorcerer/"+sorcerer.getUsername();
	}
	
	/* -- add a handler method .. to handle requests for
	      the profile page.
	 */
	@RequestMapping(value="/{username}", method=GET)
	public String showSorcererProfile(
		@PathVariable String username, Model model) {
	  Sorcerer sorcerer = sorcererDao.findByUsername(username);
	  model.addAttribute(sorcerer);		
	  return "profile";	
	}
	
}