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

import example.com.opiskelijaelama.domain.Tehtava;
import example.com.opiskelijaelama.domain.TehtavaRepository;

@Controller
public class TehtavaController {
	
	@Autowired
	private TehtavaRepository tehtavaRepo;
	
	@GetMapping("/tehtavat")
	public String etsiTehtavat(Model model) {
		model.addAttribute("tehtavat", tehtavaRepo.findAll());
		return "tehtavat"; //tehtavat.html
		
	}
	
	@GetMapping("/lisaaTehtava")
	public String lisaaTehtava(Model model) {
		model.addAttribute("tehtava", new Tehtava());
		return "lisaatehtava"; //lisaatehtava.html
	}
	
	@PostMapping("/tallennaTehtava")
	public String tallennaTehtava(@ModelAttribute Tehtava tehtava) {
		tehtavaRepo.save(tehtava);
		return "redirect:/tehtavat"; //tehtavat.html
	}
	
	@GetMapping("/poistaTehtava/{id}")
	public String poistaTehtava(@PathVariable("id") Long tehtavaId, Model model) {
	 tehtavaRepo.deleteById(tehtavaId);
	 return "redirect:../tehtavat"; //tehtavat.html
	}
	
	@RequestMapping(value = "/muokkaaTehtava/{id}", method = RequestMethod.GET)
	public String muokkaaLaulu(@PathVariable("id") Long tehtavaId, Model model) {
		model.addAttribute("tehtava", tehtavaRepo.findById(tehtavaId).get());
		return "lisaatehtava";
		
	}

}
