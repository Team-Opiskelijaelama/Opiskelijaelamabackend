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
import example.com.opiskelijaelama.domain.Laulu;
import example.com.opiskelijaelama.domain.LauluRepository;
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
	@Bean
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository tapahtumaRepo, TehtavaRepository tehtavaRepo, JuomapeliRepository peliRepo, LauluRepository lauluRepo) {
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
			
			lauluRepo.save(new Laulu("Helan går", "En liten fågel satt en gång och sjöng i furuskog."
					+ "\n"
					+ " Den hade sjungit dagen lång, men dock ej sjungit nog."
					+ "\r \n"
					+ " Vad sjöng den lilla fågeln då? JOO!"
					+ "\r \n"
					+ "Helan går, sjung hopp-fa-de-ral-lan-lal-lan-lej!"
					+ "\n"
					+ " Helan går, sjung hopp-fa-de-ral-lan-lej!"
					+ "\n"
					+ " Och den som inte Helan tar, han ej heller Halvan får. "
					+ "\n"
					+ "Helan går- "
					+ "\n"
					+ "sjung hopp-fa-de-ral-lan-lej!", "","", true));		
			lauluRepo.save(new Laulu("Vesipoikien marssi", "Pois se meistä, että täällä maisteltais` Noita pahan tuomia alkoholijuomia. Vaikka henki keltä täällä haisteltais ́  Niin huugo raikas sois ́! Hurraa, me nuoret vesipojat, Pää on selvä meillä aina, Krapulat ei meitä paina. Hurraa, me nuoret vesipojat, meillä luonto raitis on! Säyseästi näin kun aina elelee, Itseksensä hissuksiin, nenä kirjassansa kiinn ́. Tarmokkaasti lasiin aina sylkäisee, Siitä riemu verraton! Hurraa, me nuoret... Paha perii riettauden sellaisen, Jota toiset harjoittaa, Kun he itsens ́ juovuttaa. Sukukunnan turma tuopi tuollainen, kulttuurin turmion! Hurraa, me nuoret... ", "Kapteeni katsoi horisonttihin", "Ennen laulua, sen aikana ja sen jälkeen skoolatessa saa juoda vain ja ainostaan vettä. Alkoholin juominen laulun aika on rangaistava teko.", true));
			lauluRepo.save(new Laulu("Jallutähden alla", "Täällä jallutähden alla korkeimmalla kukkulalla Katson läpi lasin tyhjän, sen täytän uudestaan Täällä jallutähden alla, lasi täyttyy leikatulla Siitä suojakseni peiton, minä itselleni saan Ja alla jallutähden, minä otan, yhden tähden, ja vain jallutähden nähden, itken ilon kyyneleen Täällä jallutähden alla, kova jano laulajalla Huolet viinaa naukkaamalla siirtyy päivään huomiseen Täällä jallutähden alla, hiipii sieluun asti halla, mutta korkin avaamalla, sulaa sydän uudelleen Ja alla jallutähden... ", "Täällä Pohjantähden alla ", "allutähden alla lauletaan vain toastmasterin esityksestä ja se on perinteisesti sitsien toiseksi viimeinen laulu. Kappaleen aikana EI huudeta, eikä ennen kappaletta oteta huikkia vaan se lähtee aina hiljaisuudesta. Viimeisen kertosäkeen ajaksi noustaan seisomaan ja se lauletaan kahdesti", true));

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
