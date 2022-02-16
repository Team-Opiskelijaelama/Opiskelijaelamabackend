package example.com.opiskelijaelama.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import example.com.opiskelijaelama.domain.Tehtava;
import example.com.opiskelijaelama.domain.TehtavaRepository;

@Controller
public class TehtavaController {
	
	@Autowired
	private TehtavaRepository tehtavaRepo;
	
	@GetMapping("/tehtavat")
	public String getAllTehtava(Model model) {
		model.addAttribute("tehtavat", tehtavaRepo.findAll());
		return "tehtavat"; //tehtavat.html
		
	}
	
	@GetMapping("/addTehtava")
	public String addTehtava(Model model) {
		model.addAttribute("tehtava", new Tehtava());
		return "lisaatehtava"; //lisaatehtava.html
	}
	
	@PostMapping("/saveTehtava")
	public String saveTehtava(@ModelAttribute Tehtava tehtava) {
		tehtavaRepo.save(tehtava);
		return "redirect:/tehtavat"; //tehtavat.html
	}
	
	@GetMapping("/deleteTehtava/{id}")
	public String deleteTehtava(@PathVariable("id") Long tehtavaId, Model model) {
	 tehtavaRepo.deleteById(tehtavaId);
	 return "redirect:../tehtavat"; //tehtavat.html
	}

}
