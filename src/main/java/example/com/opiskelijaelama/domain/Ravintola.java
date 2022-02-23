package example.com.opiskelijaelama.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "appro" })
@Table(name="RAVINTOLA")
public class Ravintola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ravintolaId;
	
	private String nimi;
	
	private String osoite;
	
	private String aukiolo;
	
	@ManyToMany(mappedBy="ravintolalista", fetch = FetchType.LAZY)
	private List<Appro> approt = new ArrayList<Appro>();
	
	public Ravintola() {
		super();
	}
	
	public Ravintola(String nimi, String osoite, String aukiolo) {
		super();
		this.nimi = nimi;
		this.osoite = osoite;
		this.aukiolo = aukiolo;
	}
	
	public Long getRavintolaId() {
		return ravintolaId;
	}
	
	public void setRavintolaId(Long ravintolaId) {
		this.ravintolaId = ravintolaId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getAukiolo() {
		return aukiolo;
	}

	public void setAukiolo(String aukiolo) {
		this.aukiolo = aukiolo;
	}

	public List<Appro> getApprot() {
		return approt;
	}

	public void setApprot(List<Appro> approt) {
		this.approt = approt;
	}
	
	//Mahdollisuudet lisätä ja poistaa approja
	public void addAppro(Appro appro) {
		approt.add(appro);
		appro.getRavintolalista().add(this);
	}
			
	public void removeAppro(Appro appro) {
		approt.remove(appro);
		appro.getRavintolalista().remove(this);
	}
	
	@Override
	public String toString() {
		return "Ravintola [ravintolaId=" + ravintolaId + ", "
				+ "nimi=" + nimi + ", osoite=" + osoite +", aukiolo=" + aukiolo
				+"]";
	}
	
}
