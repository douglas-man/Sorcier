package sorcier.web;

// import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sorcier.Sorcier;
import sorcier.dao.SorcierDao;

 


@Controller
@RequestMapping("/sorciers")
public class SorcierController {
	
	private static final String MAX_LONG_AS_STRING = "9223372036854775807"/* --Long.toString(Long.MAX_VALUE) -- */;
	
	private SorcierDao sorcierDao;
	
	@Autowired
	public SorcierController(SorcierDao sorcierDao) {
		this.sorcierDao = sorcierDao;
	}
	
/*---
	@RequestMapping(method=RequestMethod.GET)
	public String sorciers(Model model) {
		model.addAttribute(
			sorcierDao.findSorciers(Long.MAX_VALUE, 20));
		return "sorciers"
	}
 --- */
 
    /* ---- alternate implementations ---- */
	@RequestMapping(method=RequestMethod.GET)
	public List<Sorcier> sorciers(
		@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
	    @RequestParam(value="count", defaultValue="20") int count) {
		return sorcierDao.findSorciers(max, count);
	}
	
	@RequestMapping(value="/{sorcierId}", method=RequestMethod.GET)
	public String sorcier(
		@PathVariable/* -- optionally omit -- ("sorcierId") -- */ long sorcierId,
		Model model) {
	  model.addAttribute(sorcierDao.findOne(sorcierId));
	  return "sorcier";	
	}
}