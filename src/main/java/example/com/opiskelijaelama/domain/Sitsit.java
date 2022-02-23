package example.com.opiskelijaelama.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("S")
@Table(name="SITSIT")
public class Sitsit extends Tapahtuma {

	private String toastmaster;
	@Column(columnDefinition = "varchar(1400)")
	private String kaytos;
	
	@ManyToMany
	@JoinTable(
			name="sitsilaulu",
	joinColumns= @JoinColumn(name = "tapahtumaId"),
	inverseJoinColumns = @JoinColumn(name = "lauluId"))
	@JsonIgnoreProperties("sitsit, tapahtuma_id")
	private List<Laulu> laulukirja = new ArrayList<Laulu>();
	
	public Sitsit() {
		super();
		this.setTapahtumaNimi("Sitsit");
		this.setTapahtumaKuvaus("Sitsit ovat akateeminen pöytäjuhla, jossa opiskelijat kokoontuvat yhteisen pöydän ääreen syömään, juomaan ja laulamaan juomalauluja. Sitseillä voi olla erilaisia teemoja, joiden mukaan valitaan ruoat ja kenties osa lauluista. Tapahtuma koostuu 3 osasta, joiden välillä on lyhyt (n. 20 min) tauko. Perinteisesti jokaisella osalla on oma ruokalajinsa, joka tarjoillaan (alkupala, pääruoka, jälkiruoka). Sitseille on hyvä varata erilaisia juomia; aina vettä sekä lisäksi oman maun mukaan muita mietoja juomia ja snapsit (perinteisesti Koskenkorva ja Jaloviina, alkoholittomille osallistujille esim. inkiväärishotti). Sitseillä laulettavat juomalaulut löytyvät tapahtuman omasta laulukirjasta.");
		this.setHenkilomaara(6);
		this.setTapahtumaSaannot("Sitsipöytään ei saa istua ennen lupaa. Sitsejä johtava toastmaster aloittaa sitsit esittelemällä itsensä, antamalla sitsikansalle luvan istua pöydän ääreen ja kertaamalla sitsisäännöt. Sitsipöydästä ei myöskään ole kohteliasta nousta ilman lupaa (poikkeuksena ilmoitetut tauot, joiden aikana pöydästä poistuminen on sallittua). Luvan voi pyytää puheenvuorolla toastmasterilta. \r\n"
				+ "\r\n"
				+ "Toastmaster jakaa puheenvuorot, hyväksyy laulutoiveet, rankaisee sääntöjen rikkojia ja ilmoittaa tauot. Puheenvuoron saa kilistelemällä omaa lasia tai viittaamalla (toastmaster määrittelee tyylin). Puheenvuoron ajaksi noustaan seisomaan ja sen alussa puhuja aina tervehtii sitsikansaa ja toastmasteria sekä esittelee itsensä. Muut tervehtivät puhujaa ”Hei, *kerrottu nimi*”. (Mikäli nimeä ei mainita, muu sitsikansa voi huutaa puhujan päälle ”KUKA SÄ OOT?”) Puheenvuoron pitäjälle voidaan esittää myös kysymyksiä (Ooksä sinkku? Onks sul metsää? tms). \r\n"
				+ "\r\n"
				+ "Laulun aloittaja voi kysyä muulta sitsikansalta, että “mistä laulu lähtee”. Tähän vastataan huutamalla “huikasta”, jolloin kaikki ottavat huikan juomastaan. Huutoja voi olla myös esim. “vesihuikasta” tai “pitkästä huikasta”. Kun huudetaan “hiljaisuudesta”, tulee huudot lopettaa ja laulu aloittaa. Laulu aloitetaan sanoin “laulu menee jota kuinkin näin”. \r\n"
				+ "\r\nHUOM. Vaikka puhutaankin sitsipöydästä, samat säännöt pätevät vaikka sitsaaminen tapahtuisi puistossa vilttien päällä istuen.  ");
		this.kaytos = "1. Toastmasterin sana on laki.  \r\n"
				+ "\r\n2. Kohtele muita kohteliaasti. Älä siis puhu toisten päälle tai käytä loukkaavaa kieltä. \r\n"
				+ "\r\n3. Puheenvuorojen/Laulujen aikana ei syödä tai puhuta. \r\n"
				+ "\r\n4. Sitseillä ei taputeta. Taputtamisen sijaan voi hakata käsillä pöytää tai tömistää jaloilla maata. \r\n"
				+ "\r\n5. Laulujen päätteeksi skoolataan vierustoverin kanssa. Perinteisesti miehet skoolaavat ensin oikealle, sitten vasemmalle ja viimeiseksi vastapäätäistuvalle, naiset taas aloittavat vasemmalta. Toastmaster voi ohjeistaa toisenlaisen käytännön. \r\n"
				+ "\r\n6. Skoolatessa katsotaan seuralaista silmiin. Laseja ei kilistellä. \r\n"
				+ "\r\n7. Puhelinta saa käyttää vain tauoilla (vain laulun sanojen katsominen on sallittua). \r\n"
				+ "\r\n8. Sääntöjen rikkomisesta seuraa rangaistus, jonka toastmaster määrää. (Rangaistuksien tulee olla hyvien makujen rajoissa, esim. anteeksipyyntöpuhe, laulun esittäminen.) \r\n"
				+ "\r\nLaulujen aikana on käytössä huudot: Omstart, joka aloittaa laulun tai säkeistön alusta, Mellansup, jonka jälkeen otetaan huikka juomasta ja Tempo, jolla laulettavan laulun nopeutta voidaan muuttaa (perinteisesti nopeammaksi, mutta voidaan myös hidastaa tai palauttaa normaaliksi; Tempo hidas tai Tempo normaali). \r\n"
				+ "\r\n10. Yksi laulu lauletaan perinteisesti vain yhden kerran. \r\n"
				+ "\r\n11. Lauluja voi jatkaa, mikäli osaa niihin lisäsäkeistöjä. Laulu päättyy, kun toastmaster huutaa “Skål!” ";
		}

	public Sitsit(String tapahtumaNimi, String tapahtumaKuvaus, int henkilomaara, String kaytos) {
		super();
		this.setTapahtumaNimi(tapahtumaNimi);
		this.setTapahtumaKuvaus(tapahtumaKuvaus);
		this.setHenkilomaara(henkilomaara);
		this.kaytos = kaytos;
	}

	public Sitsit(String tapahtumaNimi, String tapahtumaKuvaus, String tapahtumaSaannot, int henkilomaara, String toastmaster, String kaytos, List<Laulu> laulukirja) {
		super();
		this.setTapahtumaNimi(tapahtumaNimi);
		this.setTapahtumaKuvaus(tapahtumaKuvaus);
		this.setTapahtumaSaannot(tapahtumaSaannot);
		this.setHenkilomaara(henkilomaara);
		this.toastmaster = toastmaster;
		this.kaytos = kaytos;
		this.laulukirja = laulukirja;
	}
	
	public String getToastmaster() {
		return toastmaster;
	}

	public void setToastmaster(String toastmaster) {
		this.toastmaster = toastmaster;
	}

	public String getKaytos() {
		return kaytos;
	}

	public void setKaytos(String kaytos) {
		this.kaytos = kaytos;
	}

	public List<Laulu> getLaulukirja() {
		return laulukirja;
	}

	public void setLaulukirja(List<Laulu> laulukirja) {
		this.laulukirja = laulukirja;
	}
	
	// Metodit laulujen lisäämiseen/poistamiseen	
		public void addLaulu(Laulu laulu) {
			laulukirja.add(laulu);
			laulu.getSitseja().add(this);
		}
		
		public void removeLaulu(Laulu laulu) {
			laulukirja.remove(laulu);
			laulu.getSitseja().remove(this);
		}

	@Override
	public String toString() {
		return "Sitsit [toastmaster=" + toastmaster + ", kaytos=" + kaytos + ", laulukirja=" + laulukirja
				+ ", getTapahtumaId()=" + getTapahtumaId() + ", getNimi()=" + getTapahtumaNimi() +", getTapahtumaKuvaus()=" + getTapahtumaKuvaus() + ", getTapahtumaSaannot()="
				+ getTapahtumaSaannot() + ", getHenkilomaara()=" + getHenkilomaara() +  "]";
	}
	
}
