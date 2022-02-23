package example.com.opiskelijaelama.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import example.com.opiskelijaelama.domain.Appro;
import example.com.opiskelijaelama.domain.Gambinakokous;
import example.com.opiskelijaelama.domain.Rastikierros;
import example.com.opiskelijaelama.domain.Sitsit;
import example.com.opiskelijaelama.domain.Tapahtuma;
import example.com.opiskelijaelama.domain.TapahtumaRepository;


@RestController
@RequestMapping(value = "/rest")
public class RestApiController {
	
	@Autowired
	private TapahtumaRepository repository;

	// Tapahtumien 1-4 haku (tiedot kaikista tapahtumista fronttia varten
	@RequestMapping(value="/tapahtumatiedot", method = RequestMethod.GET)
    public @ResponseBody List<Tapahtuma> tapahtumatiedotRest() {
		
		List<Tapahtuma> tapahtumatiedot = new ArrayList<Tapahtuma>();
		tapahtumatiedot.add(repository.etsiAppro(Long.valueOf(4)));
		tapahtumatiedot.add(repository.etsiGambinakokous(Long.valueOf(4)));
		tapahtumatiedot.add(repository.etsiRastikierros(Long.valueOf(4)));
		tapahtumatiedot.add(repository.etsiSitsit(Long.valueOf(4)));
		
        return tapahtumatiedot;
    } 
	
	// Uuden appro-olion luonti ja haku käyttäjää varten
	@RequestMapping(value="/appro", method = RequestMethod.GET)
    public @ResponseBody Tapahtuma approRest() {
		
		Tapahtuma appro = new Appro();
		LocalDate pvm = LocalDate.now();
		DateTimeFormatter muotoilija = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		appro.setTapahtumaNimi(appro.getTapahtumaNimi() + " " + muotoilija.format(pvm));

        return appro;
    } 
	
	// Uuden gambinakokous-olion luonti ja haku käyttäjää varten
	@RequestMapping(value="/gambinakokous", method = RequestMethod.GET)
    public @ResponseBody Tapahtuma gambinakokousRest() {
		
		Tapahtuma gambinakokous = new Gambinakokous();
		LocalDate pvm = LocalDate.now();
		DateTimeFormatter muotoilija = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		gambinakokous.setTapahtumaNimi(gambinakokous.getTapahtumaNimi() + " " + muotoilija.format(pvm));

        return gambinakokous;
    } 
	
	// Uuden rastikierros-olion luonti ja haku käyttäjää varten
	@RequestMapping(value="/rastikierros", method = RequestMethod.GET)
    public @ResponseBody Tapahtuma rastikierrosRest() {
		
		Tapahtuma rastikierros = new Rastikierros();
		LocalDate pvm = LocalDate.now();
		DateTimeFormatter muotoilija = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		rastikierros.setTapahtumaNimi(rastikierros.getTapahtumaNimi() + " " + muotoilija.format(pvm));
		
        return rastikierros;
    } 
	
	// Uuden sitsit-olion luonti ja haku käyttäjää varten
	@RequestMapping(value="/sitsit", method = RequestMethod.GET)
    public @ResponseBody Tapahtuma sitsitRest() {
		
		Tapahtuma sitsit = new Sitsit();
		LocalDate pvm = LocalDate.now();
		DateTimeFormatter muotoilija = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		sitsit.setTapahtumaNimi(sitsit.getTapahtumaNimi() + " " + muotoilija.format(pvm));

        return sitsit;
    } 
	
}
