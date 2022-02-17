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
@DiscriminatorValue("A")
@Table(name="APPRO")
public class Appro extends Tapahtuma {
	
	private ArrayList<Boolean> appropassi = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name="approravintola",
	joinColumns= @JoinColumn(name = "tapahtumaId"),
	inverseJoinColumns = @JoinColumn(name = "ravintolaId"))
	@JsonIgnoreProperties("appro")
	private List<Ravintola> ravintolalista = new ArrayList<Ravintola>();
	
	
	
	public Appro() {
		super();
		this.setNimi("Appro");
		this.setKuvaus("Approt ovat opiskelijatapahtuma, jossa kierretään ennakkoon määrättyjä anniskeluravintoloita keräten merkkejä suorituspassiin. Jokaisessa anniskeluravintolassa juodaan juoma, jonka jälkeen saa merkinnän suorituspassiin.");
		this.setHenkilomaara(2);
		this.setSaannot("Suoritusmerkinnän saa juomalla vapaavalintaisen juoman kierroksen baarissa. Vain yksi merkintä/baari.");
	}
	
	public Appro(String nimi) {
		super();
		this.setNimi(nimi);
	}

	public Appro(String nimi, String saannot, int henkilomaara, ArrayList<Boolean> appropassi) {
		super();
		this.setNimi(nimi);
		this.setSaannot(saannot);
		this.setHenkilomaara(henkilomaara);
		this.appropassi= appropassi;
	}
	
	public Appro(String nimi, String saannot, int henkilomaara, ArrayList<Boolean> appropassi, List<Ravintola> ravintolalista) {
		super();
		this.setNimi(nimi);
		this.setSaannot(saannot);
		this.setHenkilomaara(henkilomaara);
		this.appropassi= appropassi;
		this.ravintolalista = ravintolalista; 
	}	
	
	public ArrayList<Boolean> getAppropassi() {
		return appropassi;
	}
	
	public void setAppropassi(ArrayList<Boolean> appropassi) {
		this.appropassi = appropassi;
	}

	
	public List<Ravintola> getRavintolalista() {
		return ravintolalista;
	}
	
	public void setRavintolalista(List<Ravintola> ravintolalista) {
		this.ravintolalista = ravintolalista;
	}
	
	// Metodit ravintoloiden lisäämiseen/poistamiseen	
	public void addRavintola(Ravintola ravintola) {
		ravintolalista.add(ravintola);
		ravintola.getApprot().add(this);
	}
			
	public void removeRavintola(Ravintola ravintola) {
		ravintolalista.remove(ravintola);
		ravintola.getApprot().remove(this);
	}
	
	@Override
	public String toString() {
		return "Approt [appropassi=" + appropassi + ", ravintolalista=" + ravintolalista + ", getTapahtumaId()="
				+ getTapahtumaId() + ", getNimi()=" + getNimi() + ", getSannot()=" + getSaannot()
				+ ", getHenkilomaara()=" + getHenkilomaara() + "]";
	}
	

}
