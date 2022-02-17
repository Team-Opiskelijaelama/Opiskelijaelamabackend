package example.com.opiskelijaelama.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import example.com.opiskelijaelama.domain.Tapahtuma;
import example.com.opiskelijaelama.domain.TapahtumaRepository;

@Controller
public class TapahtumaController {
	
	@Autowired
	private TapahtumaRepository repository;
	
	// Metodi, jolla eri tapahtumatyypit listataan etusivulle
	@RequestMapping(value="/")
	public String listaaTapahtumat(Model model) {
		
		//Tapahtuma appro = repository.etsiAppro(Long.valueOf(4));
		List<Tapahtuma> tapahtumat = new ArrayList<Tapahtuma>();
		tapahtumat.add(repository.etsiAppro(Long.valueOf(4)));
		tapahtumat.add(repository.etsiGambinakokous(Long.valueOf(4)));
		tapahtumat.add(repository.etsiRastikierros(Long.valueOf(4)));
		tapahtumat.add(repository.etsiSitsit(Long.valueOf(4)));
		
		model.addAttribute("tapahtumat", tapahtumat);
		
		return "index";
		}
	
	}
	

