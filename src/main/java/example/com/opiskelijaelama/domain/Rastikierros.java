package example.com.opiskelijaelama.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("R")
@Table(name="RASTIKIERROS")
public class Rastikierros extends Tapahtuma {
	
	private ArrayList<Boolean> suorituspassi = new ArrayList<Boolean>();
	
	@ManyToMany
	@JoinTable(
			name="rastitehtava",
	joinColumns= @JoinColumn(name = "tapahtumaId"),
	inverseJoinColumns = @JoinColumn(name = "tehtavaId"))
	@JsonIgnoreProperties("rastikierros")
	private List<Tehtava> tehtavalista = new ArrayList<Tehtava>();
	
	
	public Rastikierros() {
		super();
		this.setNimi("Rastikierros");
		this.setKuvaus("Toiminnallinen kierros, jonka aikana pääsee suorittamaan satunnaisia tehtäviä");
		this.setHenkilomaara(2);
		this.setSaannot("Suoritetusta tehtävästä saa merkinnän.");
	}
	
	public Rastikierros(String nimi, String kuvaus, String saannot, int henkilomaara) {
		super();
		this.setNimi(nimi);
		this.setKuvaus(kuvaus);
		this.setSaannot(saannot);
		this.setHenkilomaara(henkilomaara);
	}

	public Rastikierros(String nimi, String kuvaus, String saannot, int henkilomaara, ArrayList <Boolean> suorituspassi) {
		super();
		this.setNimi(nimi);
		this.setKuvaus(kuvaus);
		this.setSaannot(saannot);
		this.setHenkilomaara(henkilomaara);
		this.suorituspassi = suorituspassi;
	}

	public Rastikierros(String nimi, String kuvaus, String saannot, int henkilomaara, ArrayList<Boolean> suorituspassi, List<Tehtava> tehtavalista) {
		super();
		this.setNimi(nimi);
		this.setKuvaus(kuvaus);
		this.setSaannot(saannot);
		this.setHenkilomaara(henkilomaara);
		this.suorituspassi = suorituspassi;
		this.tehtavalista = tehtavalista;
	}

	public ArrayList<Boolean> isSuorituspassi() {
		return suorituspassi;
	}

	public void setSuorituspassi(ArrayList<Boolean> suorituspassi) {
		this.suorituspassi = suorituspassi;
	}

	public List<Tehtava> getTehtavalista() {
		return tehtavalista;
	}

	public void setTehtavalista(List<Tehtava> tehtavalista) {
		this.tehtavalista = tehtavalista;
	}

	// Metodit tehtävien lisäämiseen/poistamiseen	
	public void addTehtava(Tehtava tehtava) {
		tehtavalista.add(tehtava);
		tehtava.getRastikierrokset().add(this);
	}
			
	public void removeTehtava(Tehtava tehtava) {
		tehtavalista.remove(tehtava);
		tehtava.getRastikierrokset().remove(this);
	}
	
	@Override
	public String toString() {
		return "Rastikierros [suorituspassi=" + suorituspassi + ", tehtavalista=" + tehtavalista + ", getTapahtumaId()="
				+ getTapahtumaId() + ", getNimi()=" + getNimi() + ", getSaannot()=" + getSaannot()
				+ ", getHenkilomaara()=" + getHenkilomaara() + "]";
	}

}
