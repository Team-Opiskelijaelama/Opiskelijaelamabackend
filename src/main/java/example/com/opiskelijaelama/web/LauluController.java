package example.com.opiskelijaelama.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.com.opiskelijaelama.domain.Laulu;
import example.com.opiskelijaelama.domain.LauluRepository;

@Controller
public class LauluController {
	
	@Autowired
	private LauluRepository lauluRepo;
	
	@GetMapping("/laulut")
	public String getAllLaulu(Model model) {
		model.addAttribute("laulut", lauluRepo.findAll());
		return "laulut"; //laulut.html
		
	}
	
	@GetMapping("/addLaulu")
	public String addLaulu(Model model) {
		model.addAttribute("laulu", new Laulu());
		return "lisaalaulu"; //lisaalaulu.html
	}
	
	@PostMapping("/saveLaulu")
	public String saveLaulu(@ModelAttribute Laulu laulu) {
		lauluRepo.save(laulu);
		return "redirect:/laulut"; //laulut.html
	}
	
	@RequestMapping(value = "deleteLaulu/{id}")
	public String deleteLaulu(@PathVariable("id") Long lauluId, Model model) {
		lauluRepo.deleteById(lauluId);
		return "redirect:/laulut";
	}
	
	@RequestMapping(value = "/editLaulu/{id}", method = RequestMethod.GET)
	public String editLaulu(@PathVariable("id") Long lauluId, Model model) {
		model.addAttribute("laulu", lauluRepo.findById(lauluId).get());
		return "lisaalaulu";
		
	}
	
	
}
