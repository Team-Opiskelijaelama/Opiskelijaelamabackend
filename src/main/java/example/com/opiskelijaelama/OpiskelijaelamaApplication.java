package example.com.opiskelijaelama;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import example.com.opiskelijaelama.domain.Appro;
import example.com.opiskelijaelama.domain.Gambinakokous;
import example.com.opiskelijaelama.domain.Juomapeli;
import example.com.opiskelijaelama.domain.JuomapeliRepository;
import example.com.opiskelijaelama.domain.Rastikierros;
import example.com.opiskelijaelama.domain.Sitsit;
import example.com.opiskelijaelama.domain.TapahtumaRepository;
import example.com.opiskelijaelama.domain.Tehtava;
import example.com.opiskelijaelama.domain.TehtavaRepository;



@SpringBootApplication
public class OpiskelijaelamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpiskelijaelamaApplication.class, args);
	}
	//testikommentti
	@Bean
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository tapahtumaRepo, TehtavaRepository tehtavaRepo, JuomapeliRepository peliRepo) {
		return (args) -> {


			Sitsit sitsit1 = new Sitsit();
			
			Rastikierros rastikierros1 = new Rastikierros();
			
			Gambinakokous gambinakokous1 = new Gambinakokous ();
			
			Appro appro1 = new Appro();
			
			Tehtava tehtava1 = new Tehtava("Tehtava1", "Tehdään jotain");
			Tehtava tehtava2 = new Tehtava("Tehtava2", "Ihmispyramidi");
			Tehtava tehtava3 = new Tehtava("Tehtava3", "Shotgun");
			Tehtava tehtava4 = new Tehtava("Tehtava4", "Laula laulu");
			
			Juomapeli peli1 = new Juomapeli("Hitler", "Pelikortit", "Jokainen pelaaja nostaa pakastaan vuorollaan kortin. Jokaisella kortilla oma merkityksensä...");
			Juomapeli peli2 = new Juomapeli("En ole koskaan", "Jokainen pelaaja kertoo vuorollaan asian, jota ei ole tehnyt koskaan. Ne pelaajista, jotka ovat tehneet kyseisen asian, ottavat huikan.");
			Juomapeli peli3 = new Juomapeli("Fizz Buzz", "Pelaajat istuvat ringissä. Ensimmäinen pelaaja aloittaa sanomalla luvun ”1”. Tämän jälkeen pelaajat luettelevat vuorotellen lukuja ykkösestä ylöspäin. Kaikki luvut, jotka ovat kolmella jaollisia korvataan sanalla Fizz. Kaikki luvut, jotka ovat jaollisia luvulla 5 korvataan sanalla Buzz. Jos luku on jaollinen sekä kolmella että viidellä, sanotaan Fizz Buzz. Jos pelaaja epäröi tai tekee virheen, niin hän joutuu juomaan.");

			tapahtumaRepo.save(sitsit1);
			tapahtumaRepo.save(rastikierros1);
			tapahtumaRepo.save(gambinakokous1);
			tapahtumaRepo.save(appro1);
			tehtavaRepo.save(tehtava1);
			tehtavaRepo.save(tehtava2);
			tehtavaRepo.save(tehtava3);
			tehtavaRepo.save(tehtava4);
			peliRepo.save(peli1);
			peliRepo.save(peli2);
			peliRepo.save(peli3);
		};
	}


}
