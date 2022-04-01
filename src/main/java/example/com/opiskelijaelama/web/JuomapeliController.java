package example.com.opiskelijaelama.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import example.com.opiskelijaelama.domain.JuomapeliRepository;

@Controller
public class JuomapeliController {
	
	@Autowired
	private JuomapeliRepository peliRepo;
	
	@GetMapping("/juomapelit")
	public String etsiJuomapelit(Model model) {
		model.addAttribute("juomapelit", peliRepo.findAll());
		return "juomapelit"; //juomapelit.html
		
	}

}
