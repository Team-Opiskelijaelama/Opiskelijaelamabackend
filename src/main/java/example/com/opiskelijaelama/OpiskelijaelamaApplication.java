package example.com.opiskelijaelama;



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
			
			Tehtava tehtava1 = new Tehtava("Ihmispyramidi", "Tehkää ihmispyramidi.");
			Tehtava tehtava2 = new Tehtava("Shotgun", "Tehkää tölkin alaosaan reikä ja sen jälkeen juokaa olut reiän kautta mahdollisimman nopeasti.");
			Tehtava tehtava3 = new Tehtava("Laula laulu", "Laula haluamasi laulu tai laulunpätkä.");
			Tehtava tehtava4 = new Tehtava("Etsi kynä", "Yhden ryhmän jäsenen tehtävänä on löytää kynä mahdollisimman nopeasti ja tuoda se takaisin lähtöpaikalle.");
			Tehtava tehtava5 = new Tehtava("Trade up!", "Ottakaa jotain arvotonta, joka teillä jo on (esimerkiksi viiden sentin kolikko tai kynä) ja pyrkikää vaihtokaupan keinoin saavuttamaan sen avulla jotain hienompaa.");
			Tehtava tehtava6 = new Tehtava("Myy kynä", "Yksi ryhmästä pitää pitchin, jonka tarkoituksena on saada (imaginäärinen) kynä kaupaksi.");
			Tehtava tehtava7 = new Tehtava("Party trick", "Jokainen ryhmän jäsen demonstroi omaa “party trickiään” samanaikaisesti.");
			Tehtava tehtava8 = new Tehtava("Signature dance", "Jokainen ryhmän jäsen tanssii omaa mooviaan samanaikaisesti.");
			Tehtava tehtava9 = new Tehtava("Juoma loppuun", "Juo juomasi kokonaan loppuun.");
			Tehtava tehtava10 = new Tehtava("Uno", "Pelatkaa kierros Unoa.");
			
			Juomapeli peli1 = new Juomapeli("Hitler", "Pelikortit", "Jokainen pelaaja nostaa pakastaan vuorollaan kortin. Jokaisella kortilla oma merkityksensä...");
			Juomapeli peli2 = new Juomapeli("En ole koskaan", "Jokainen pelaaja kertoo vuorollaan asian, jota ei ole tehnyt koskaan. Ne pelaajista, jotka ovat tehneet kyseisen asian, ottavat huikan.");
			Juomapeli peli3 = new Juomapeli("Fizz Buzz", "Pelaajat istuvat ringissä. Ensimmäinen pelaaja aloittaa sanomalla luvun ”1”. Tämän jälkeen pelaajat luettelevat vuorotellen lukuja ykkösestä ylöspäin. Kaikki luvut, jotka ovat kolmella jaollisia korvataan sanalla Fizz. Kaikki luvut, jotka ovat jaollisia luvulla 5 korvataan sanalla Buzz. Jos luku on jaollinen sekä kolmella että viidellä, sanotaan Fizz Buzz. Jos pelaaja epäröi tai tekee virheen, niin hän joutuu juomaan.");
			Juomapeli peli4 = new Juomapeli("Kaljakäsi Edward", "Ilmastointiteippiä", "Teippaa pullo tai tölkki käsiisi ja yritä juoda ne.");
			Juomapeli peli5 = new Juomapeli("Kolikot", "Kolikkoja, Shottilasi", "Pompauta kolikko pöydän kautta lasiin. Jos onnistut, saat päättää kuka juo.");
			
			Laulu laulu1 = new Laulu("Helan går", "En liten fågel satt en gång och sjöng i furuskog."
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
					+ "sjung hopp-fa-de-ral-lan-lej!", "","", true);		
			Laulu laulu2 = new Laulu("Vesipoikien marssi", "Pois se meistä, että täällä maisteltais`\nNoita pahan tuomia alkoholijuomia.\nVaikka henki keltä täällä haisteltais\nNiin huugo raikas sois\n\nHurraa, me nuoret vesipojat,\nPää on selvä meillä aina,\nKrapulat ei meitä paina.\nHurraa, me nuoret vesipojat,\nmeillä luonto raitis on!\n\nSäyseästi näin kun aina elelee,\nItseksensä hissuksiin,\nnenä kirjassansa kiinn\nTarmokkaasti lasiin aina sylkäisee,\nSiitä riemu verraton!\n\nHurraa, me nuoret...\n\nPaha perii riettauden sellaisen,\nJota toiset harjoittaa,\nKun he itsens ́ juovuttaa.\nSukukunnan turma tuopi tuollainen,\nkulttuurin turmion!\n\nHurraa, me nuoret... ", "Kapteeni katsoi horisonttihin", "Ennen laulua, sen aikana ja sen jälkeen skoolatessa saa juoda vain ja ainostaan vettä. Alkoholin juominen laulun aika on rangaistava teko.", true);
			Laulu laulu3 = new Laulu("Jallutähden alla", "Täällä jallutähden alla\nkorkeimmalla kukkulalla\nKatson läpi lasin tyhjän,\nsen täytän uudestaan\n\nTäällä jallutähden alla,\nlasi täyttyy leikatulla\nSiitä suojakseni peiton,\nminä itselleni saan\n\nJa alla jallutähden,\nminä otan, yhden tähden,\nja vain jallutähden nähden,\nitken ilon kyyneleen\n\nTäällä jallutähden alla,\nkova jano laulajalla\nHuolet viinaa naukkaamalla\nsiirtyy päivään huomiseen\n\nTäällä jallutähden alla,\nhiipii sieluun asti halla,\nmutta korkin avaamalla,\nsulaa sydän uudelleen\n\nJa alla jallutähden... ", "Täällä Pohjantähden alla ", "Jallutähden alla lauletaan vain toastmasterin esityksestä ja se on perinteisesti sitsien toiseksi viimeinen laulu. Kappaleen aikana EI huudeta, eikä ennen kappaletta oteta huikkia vaan se lähtee aina hiljaisuudesta. Viimeisen kertosäkeen ajaksi noustaan seisomaan ja se lauletaan kahdesti", true);
			Laulu laulu4 = new Laulu("Ken ompi fuksi", "Ken ompi fuksi '22, ylös nouskohon!  \r\n"
					+ "\r\n"
					+ "Ken ompi fuksi '22, ylös nouskohon! \r\n"
					+ "\r\n"
					+ "Hän lasin käteen ottakoon  \r\n"
					+ "\r\n"
					+ "ja huulilleen sen nostakoon \r\n"
					+ "\r\n"
					+ "Juo pois, juo pois, juo pois, juo pois,  \r\n"
					+ "\r\n"
					+ "juo Herran tähden pois! (Juo pois!)  \r\n"
					+ "\r\n"
					+ "Juo pois, juo pois, juo pois, juo pois,  \r\n"
					+ "\r\n"
					+ "juo Herran tähden pois! (Juo pois!) \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Ken ompi fuksi '21...  \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Ken ompi fuksi '20... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Ken ompi fuksi ylipäänsä..  ", "", "Laulu lauletaan vain toastmasterin pyynnöstä ja se on perinteisesti sitsien viimeinen laulu. Laulun aikana tai sitä ennen ei huudeta. Laulu aloitetaan kuluvasta vuodesta ja sitä lauletaan niin kauan, kunnes kaikkien osallistujien fuksivuosi on mainittu. Jokainen osallistuja nousee oman fuksivuotensa kohdalla seisomaan, juo lasinsa tyhjäksi säkeistön aikana (& kääntää lasin ylösalaisin oman pään yläpuolella todisteeksi) ja istuu alas. ”Juo pois, juo pois, juo pois…” -kohtaa lauletaan niin kauan, kunnes kaikki seisomaan nousseet ovat juoneet juomansa ja istuneet alas, vasta sitten siirrytään eteenpäin. ", true);
			Laulu laulu5 = new Laulu("Silja Line Special", "Tahtoisin ginitonicin, ginitonicin, \r\n"
					+ "\r\n"
					+ "tai sitten minttufernetin, minttufernetin \r\n"
					+ "\r\n"
					+ "Kelpais myös kossuvissykin, kossuvissykin \r\n"
					+ "\r\n"
					+ "Nyt juhlitaan, nyt juhlitaan \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Jos saisin ison tuopposen, ison tuopposen \r\n"
					+ "\r\n"
					+ "tai sitten pullo-olusen, pullo-olusen \r\n"
					+ "\r\n"
					+ "Kelpaisi tölkkiölppäkin, tölkkiölppäkin \r\n"
					+ "\r\n"
					+ "Nyt ryypätään, nyt ryypätää \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Jos saisin, mitä tekisin, mitä tekisin, \r\n"
					+ "\r\n"
					+ "kyll' varmaan jotain keksisin, jotain keksisin, \r\n"
					+ "\r\n"
					+ "tai sitten kotiin juoksisin, kotiin juoksisin \r\n"
					+ "\r\n"
					+ "Nyt jänistää, nyt jänistää \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Kyl pojat eilen häpesin, eilen häpesin, \r\n"
					+ "\r\n"
					+ "kun yhden tytön tapasin, tytön tapasin, \r\n"
					+ "\r\n"
					+ "ja sitten homman mokasin, homman mokasin \r\n"
					+ "\r\n"
					+ "Nyt hävettää, nyt hävettää \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Kun taas on naama valkoinen, naama valkoinen \r\n"
					+ "\r\n"
					+ "taas maistuis olut huurteinen, olut huurteinen \r\n"
					+ "\r\n"
					+ "Juon sitä kolpakollisen, kolpakollisen \r\n"
					+ "\r\n"
					+ "ja oksennan, yli laidan ", "Silja Linen mainoskappale", "", false);
			Laulu laulu6 = new Laulu("Tähtilaulu", "Meidän pullossa, meidän pullossa \r\n"
					+ "\r\n"
					+ "siinä on yksi tähti kyljessä. \r\n"
					+ "\r\n"
					+ "Ja se kumotaan, ja se kumotaan \r\n"
					+ "\r\n"
					+ "siis kaikki kännäämään! \r\n"
					+ "\r\n"
					+ "Ykköstähti! \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Meidän pullossa, meidän pullossa \r\n"
					+ "\r\n"
					+ "siinä on kaksi tähtee kyljessä \r\n"
					+ "\r\n"
					+ "Ja se kumotaan, ja se kumotaan \r\n"
					+ "\r\n"
					+ "siis kaikki kännäämään! \r\n"
					+ "\r\n"
					+ "Kakkostähti! \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Meidän pullossa, meidän pullossa \r\n"
					+ "\r\n"
					+ "siinä on kolme tähtee kyljessä \r\n"
					+ "\r\n"
					+ "Ja se kumotaan, ja se kumotaan \r\n"
					+ "\r\n"
					+ "siis kaikki kännäämään! \r\n"
					+ "\r\n"
					+ "Kolmostähti! ", "Pumppulaulu", "", false);
			Laulu laulu7 = new Laulu("Vitutus-laulu", ":,:Voi saatana, voi perkele, \r\n"
					+ "\r\n"
					+ "voi jumalauta, vittu:,: ", "", "", false);
			Laulu laulu8 = new Laulu("Sen siiderin", "Sen siiderin,  \r\n"
					+ "\r\n"
					+ "sen siiderin, \r\n"
					+ "\r\n"
					+ "sen siiderin kumoon imen. \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Viskaan helttaani mä sen, \r\n"
					+ "\r\n"
					+ "kaljaa vihaan, \r\n"
					+ "\r\n"
					+ "viskaa taas kulkkuun sen! ", "Den Glider In", "", false);
			Laulu laulu9 = new Laulu("Eurovision", "Ranskassa juodaan viiniä, \r\n"
					+ "\r\n"
					+ "Saksassa olutta ja \r\n"
					+ "\r\n"
					+ "Venäjällä vodkaa. \r\n"
					+ "\r\n"
					+ "Suomessa juodaan kaikkea, \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa!  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Norjassa poltetaan kirkkoja, \r\n"
					+ "\r\n"
					+ "Hollannissa pilveä ja  \r\n"
					+ "\r\n"
					+ "Venäjällä vodkaa. \r\n"
					+ "\r\n"
					+ "Suomessa poltetaan kaikkea, \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa!  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Norjassa syödään lunta, \r\n"
					+ "\r\n"
					+ "Ruotsissa loskaa, \r\n"
					+ "\r\n"
					+ "Venäjällä paskaa. \r\n"
					+ "\r\n"
					+ "Suomessa syödään kaikkea, \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa! \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Grillissä palaa hiili, \r\n"
					+ "\r\n"
					+ "Juostessa rasva, \r\n"
					+ "\r\n"
					+ "Javan kanssa pinna. \r\n"
					+ "\r\n"
					+ "Maksassa palaa viina, \r\n"
					+ "\r\n"
					+ "Siis malja sitä nostakaa!  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kirkossa lauletaan virsiä, \r\n"
					+ "\r\n"
					+ "Tuskassa heviä, eläkkeellä humppaa. \r\n"
					+ "\r\n"
					+ "Sitseillä lauletaan kaikkea, \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa!  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kesällä sataa vettä,  \r\n"
					+ "\r\n"
					+ "Syksyllä vettä, talvella vettä  \r\n"
					+ "\r\n"
					+ "Keväällä sataa paskaa \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa! \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Vappuna juodaan skumppaa,  \r\n"
					+ "\r\n"
					+ "Etkoilla boolia, jatkoilla kaljaa.  \r\n"
					+ "\r\n"
					+ "Sitseillä juodaan kaikkea, \r\n"
					+ "\r\n"
					+ "Siis malja sille nostakaa! ", "", "Kuten laulun sanoista voi päätellä, jokaisen säkeen jälkeen nostetaan malja ja otetaan huikka (Ei tarvetta mellansup-huudolle). ", false);
			Laulu laulu10 = new Laulu("Testamentti", "Kun mä kuolen, snapsilasini sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, snapsilasini sä saat \r\n"
					+ "\r\n"
					+ "Sillä taivaan kapakoissa, \r\n"
					+ "\r\n"
					+ "Snapsit juodaan kolpakoista \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, snapsilasini sä saat  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, rintaliivini sä saat  \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, rintaliivini sä saat  \r\n"
					+ "\r\n"
					+ "Sillä rinnat taivahaiset, \r\n"
					+ "\r\n"
					+ "Eivät riipu niin kuin maiset \r\n"
					+ "\r\n"
					+ "Kun mä kuolen rintaliivini sä saat \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen partasutini sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen partasutini sä saat  \r\n"
					+ "\r\n"
					+ "Enkeleil’ on partasuti, \r\n"
					+ "\r\n"
					+ "Joka sanoo kutikuti. \r\n"
					+ "\r\n"
					+ "Kun mä kuolen partasutini sä saat  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pornolehteni sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pornolehteni sä saat \r\n"
					+ "\r\n"
					+ "Sivut yhteen liimautuivat,  \r\n"
					+ "\r\n"
					+ "Vedin niihin parit kuivat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pornolehteni sä saat \r\n"
					+ "\r\n"
					+ "    \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, vanhan heilani sä saat.   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, vanhan heilani sä saat.   \r\n"
					+ "\r\n"
					+ "Sen voin jättää ihanuuden, \r\n"
					+ "\r\n"
					+ "Kun saan enkelistä uuden. \r\n"
					+ "\r\n"
					+ "Kun mä kuolen, vanhan heilani sä saat.  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen vanhan anoppini saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen vanhan anoppini saat \r\n"
					+ "\r\n"
					+ "Sen kun pääsen narinasta, \r\n"
					+ "\r\n"
					+ "Olen onnellinen vasta \r\n"
					+ "\r\n"
					+ "Kun mä kuolen vanhan anoppini saat  \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen minkkiturkkini sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen minkkiturkkini sä saat \r\n"
					+ "\r\n"
					+ "Ei siis liene syytä huoleen, \r\n"
					+ "\r\n"
					+ "jos ne sukupuuttoon kuolee \r\n"
					+ "\r\n"
					+ "Kun mä kuolen minkkiturkkini sä saat \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kaikki tupakkani saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kaikki tupakkani saat \r\n"
					+ "\r\n"
					+ "Sillä luona taivaan portin, \r\n"
					+ "\r\n"
					+ "tarjoo Pietar mulle nortin \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kaikki tupakkani saat \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen viinakätköni sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen viinakätköni sä saat \r\n"
					+ "\r\n"
					+ "Se on tuolla ladon alla,  \r\n"
					+ "\r\n"
					+ "Kolmas kivi vasemmalla  \r\n"
					+ "\r\n"
					+ "Kun mä kuolen viinakätköni sä saat \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Kun mä kuolen ajokorttini sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen ajokorttini sä saat \r\n"
					+ "\r\n"
					+ "Taivaan siipiliikenteessä \r\n"
					+ "\r\n"
					+ "ei oo ratsioita eessä \r\n"
					+ "\r\n"
					+ "Kun mä kuolen ajokorttini sä saat \r\n"
					+ "\r\n"
					+ "   \r\n"
					+ "\r\n"
					+ "Kun mä kuolen taskumattini sä saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen taskumattini sä saat \r\n"
					+ "\r\n"
					+ "Sillä taivaassa kun juodaan, \r\n"
					+ "\r\n"
					+ "Siellä ämpäreillä tuodaan \r\n"
					+ "\r\n"
					+ "Kun mä kuolen taskumattini sä saat \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kortsupakettini saat \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kortsupakettini saat \r\n"
					+ "\r\n"
					+ "Sillä taivaassa ei panna, \r\n"
					+ "\r\n"
					+ "Koska enkelit ei anna \r\n"
					+ "\r\n"
					+ "Kun mä kuolen kortsupakettini saat \r\n"
					+ "\r\n"
					+ "  \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pullo arkkuun laittakaa \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pullo arkkuun laittakaa \r\n"
					+ "\r\n"
					+ "Sillä elo ilman viinaa,  \r\n"
					+ "\r\n"
					+ "Ompi taivaassakin piinaa \r\n"
					+ "\r\n"
					+ "Kun mä kuolen pullo arkkuun laittakaa ", "", "", false);
			Laulu laulu11 = new Laulu("Gambina", "Muistat konjakin, tequilan, romminkin varmaan \r\n"
					+ "\r\n"
					+ "Ja Koskenkorvan ja Martinin karvaan \r\n"
					+ "\r\n"
					+ "Mutta juoma tää, sulta usein unholaan jää… \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Gambina cocktailjuoma, punainen on väriltään \r\n"
					+ "\r\n"
					+ "Liene ei liian huono, Gambiinamme kellekkään \r\n"
					+ "\r\n"
					+ "Haukkuivat toiset illoin, tärpätiksi pilkaten \r\n"
					+ "\r\n"
					+ "Tuosta vain saikin silloin, juhlijamme aattehen: \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Sitsi-ilta pitkä on, laulumaraton \r\n"
					+ "\r\n"
					+ "Gambina vois mukanaan, viedä sieltä humalaan! \r\n"
					+ "\r\n"
					+ "Gambina siitä asti, laukussa matkaten \r\n"
					+ "\r\n"
					+ "Nousuun saa joutuisasti, juhlamielen iloisen ", "Petteri Punakuono", "", false);
			Laulu laulu12 = new Laulu("Bussikuski", "On meillä hauska setä, nyt bussikuskina, \r\n"
					+ "Kun setä ajaa bussia on näky komia. \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin heiluu bussi ja bussi heiluu näin. :,: \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin kaatuu tolppa... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin kuolee kissa... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin lentää mummo... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin kaatuu bussi... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin särkyy bussi... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin vilkkuu valo... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin ulvoo pilli... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin vietiin kuski Jussi... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin palaa proppu... \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ ":,: Kas näin sammuu Jussi... ", "Täti Monika", "", false);
			Laulu laulu13 = new Laulu("Huutolaatta", "Juon mä hiukan viinaa, sitten oksennan, oksennan. \r\n"
					+ "Vessaan ryömin, sielläkin mä oksennan, oksennan. \r\n"
					+ "Huu-uutolaa-aatta, huu-uutolaa-aatta. \r\n"
					+ "Oksennan, oksennan. \r\n"
					+ "Laatta se lennähtää. \r\n"
					+ "Ei vittu kun iljettää. \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Nyt tuntuu heikolta, vatsassa kiertää taas. \r\n"
					+ "Taidanpa piipahtaa, mä nurkan takana. \r\n"
					+ "Hetken jo helpottaa, elämä voittaa taas. \r\n"
					+ "Ei, olin väärässä! Väistäkää, saatana! \r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Juon mä hiukan viinaa... ", "Cicapo", "", false);
			
			
			
			tapahtumaRepo.save(sitsit1);
			tapahtumaRepo.save(rastikierros1);
			tapahtumaRepo.save(gambinakokous1);
			tapahtumaRepo.save(appro1);
			tehtavaRepo.save(tehtava1);
			tehtavaRepo.save(tehtava2);
			tehtavaRepo.save(tehtava3);
			tehtavaRepo.save(tehtava4);
			tehtavaRepo.save(tehtava5);
			tehtavaRepo.save(tehtava6);
			tehtavaRepo.save(tehtava7);
			tehtavaRepo.save(tehtava8);
			tehtavaRepo.save(tehtava9);
			tehtavaRepo.save(tehtava10);
			peliRepo.save(peli1);
			peliRepo.save(peli2);
			peliRepo.save(peli3);
			peliRepo.save(peli4);
			peliRepo.save(peli5);
			lauluRepo.save(laulu1);
			lauluRepo.save(laulu2);
			lauluRepo.save(laulu3);
			lauluRepo.save(laulu4);
			lauluRepo.save(laulu5);
			lauluRepo.save(laulu6);
			lauluRepo.save(laulu7);
			lauluRepo.save(laulu8);
			lauluRepo.save(laulu9);
			lauluRepo.save(laulu10);
			lauluRepo.save(laulu11);
			lauluRepo.save(laulu12);
			lauluRepo.save(laulu13);

			
		};
	}


}
