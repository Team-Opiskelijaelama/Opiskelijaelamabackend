package example.com.opiskelijaelama.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import example.com.opiskelijaelama.domain.Appro;
import example.com.opiskelijaelama.domain.Gambinakokous;
import example.com.opiskelijaelama.domain.Juomapeli;
import example.com.opiskelijaelama.domain.JuomapeliRepository;
import example.com.opiskelijaelama.domain.Laulu;
import example.com.opiskelijaelama.domain.Rastikierros;
import example.com.opiskelijaelama.domain.Sitsit;
import example.com.opiskelijaelama.domain.Tapahtuma;
import example.com.opiskelijaelama.domain.TapahtumaRepository;
import example.com.opiskelijaelama.domain.Tehtava;
import example.com.opiskelijaelama.domain.LauluRepository;
import example.com.opiskelijaelama.domain.TehtavaRepository;


@RestController
@RequestMapping(value = "/rest")
public class RestApiController {
	
	@Autowired 
	private JuomapeliRepository pelirepo; 
	
    // juomapelit
    @RequestMapping(value="/juomapelit", method = RequestMethod.GET)
    public List<Juomapeli> JuomapeliRepository()
    {	
        return pelirepo.findAll();
    }    
    
	@Autowired 
	private LauluRepository laulurepo; 
    
    // laulut
    @RequestMapping(value="/laulut", method = RequestMethod.GET)
    public List<Laulu> LauluRepository()
    {	
        return laulurepo.findAll();
    }   
    
	@Autowired 
	private TehtavaRepository tehtavarepo; 
    
    // tehtävät
    @RequestMapping(value="/tehtavat", method = RequestMethod.GET)
    public List<Tehtava> TehtavaRepository()
    {	
        return tehtavarepo.findAll();
    }   
	
	@Autowired
	private TapahtumaRepository repository;

	// Tapahtumien 1-4 haku (tiedot kaikista tapahtumista fronttia varten)
	@RequestMapping(value="/tapahtumat", method = RequestMethod.GET)
    public @ResponseBody List<Tapahtuma> tapahtumatiedotRest() {
		
		List<Tapahtuma> tapahtumat = repository.etsiTapahtumatiedot(Long.valueOf(4));
		Collections.sort(tapahtumat);
        return tapahtumat;
    } 
	
	// Uuden tapahtuma-olion luonti ja haku käyttäjää varten
	@RequestMapping(value="/tapahtuma/{tapahtuma}", method = RequestMethod.GET)
    public @ResponseBody Tapahtuma testRest(@PathVariable("tapahtuma") String tyyppi) throws Exception {
		
		try {
		LocalDate pvm = LocalDate.now();
		DateTimeFormatter muotoilija = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		switch(tyyppi) {
		  	case "A":
		  		Tapahtuma appro = new Appro();
				appro.setTapahtumaNimi(appro.getTapahtumaNimi() + " " + muotoilija.format(pvm));
				return appro;
		  	case "G":
		  		Tapahtuma gambinakokous = new Gambinakokous();
				gambinakokous.setTapahtumaNimi(gambinakokous.getTapahtumaNimi() + " " + muotoilija.format(pvm));
				return gambinakokous;
		  	case "R":
		  		Tapahtuma rastikierros = new Rastikierros();
				rastikierros.setTapahtumaNimi(rastikierros.getTapahtumaNimi() + " " + muotoilija.format(pvm));
		        return rastikierros;
		  	case "S":
		  		Tapahtuma sitsit = new Sitsit();	
				sitsit.setTapahtumaNimi(sitsit.getTapahtumaNimi() + " " + muotoilija.format(pvm));
		        return sitsit;
		}
		} catch (Exception e){
			System.out.println("Nyt kävi joku virhe");
		}
		return null;
    } 
	
}
