package example.com.opiskelijaelama.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "sitsit" })
@Table(name="laulu")
public class Laulu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lauluId;
	
	private String nimi;
	
	@Column(columnDefinition = "varchar(1500)")
	private String sanat;
	
	private String savel;

	@Column(columnDefinition = "varchar(1500)")
	private String ohje;
	
	private Boolean pakollinen;
	
	
	@ManyToMany(mappedBy="laulukirja", fetch = FetchType.LAZY)
	private List<Sitsit> sitseja = new ArrayList<Sitsit>();


	public Laulu() {
		super();
	}
	
	public Laulu(String nimi, String sanat, Boolean pakollinen) {
		super();
		this.nimi = nimi;
		this.sanat = sanat;
		this.pakollinen = pakollinen;
	}
	
	public Laulu(String nimi, String sanat, String savel, Boolean pakollinen) {
		super();
		this.nimi = nimi;
		this.sanat = sanat;
		this.savel = savel;
		this.pakollinen = pakollinen;
	}
	
	public Laulu(String nimi, String sanat, String savel, String ohje, Boolean pakollinen) {
		super();
		this.nimi = nimi;
		this.sanat = sanat;
		this.savel = savel;
		this.ohje = ohje;
		this.pakollinen = pakollinen;
	}

	public Long getLauluId() {
		return lauluId;
	}

	public void setLauluId(Long lauluId) {
		this.lauluId = lauluId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getSanat() {
		return sanat;
	}

	public void setSanat(String sanat) {
		this.sanat = sanat;
	}

	public String getSavel() {
		return savel;
	}

	public void setSavel(String savel) {
		this.savel = savel;
	}

	public String getOhje() {
		return ohje;
	}

	public void setOhje(String ohje) {
		this.ohje = ohje;
	}
	
	public Boolean getPakollinen() {
		return pakollinen;
	}

	public void setPakollinen(Boolean pakollinen) {
		this.pakollinen = pakollinen;
	}

	public List<Sitsit> getSitseja() {
		return sitseja;
	}

	public void setSitsseja(List<Sitsit> sitseja) {
		this.sitseja = sitseja;
	}

	//Mahdollisuudet lisätä ja poistaa sitsejä
	public void addSitsit(Sitsit sitsit) {
		sitseja.add(sitsit);
		sitsit.getLaulukirja().add(this);
	}
		
	public void removeSitsit(Sitsit sitsit) {
		sitseja.remove(sitsit);
		sitsit.getLaulukirja().remove(this);
	}

	@Override
	public String toString() {
		return "Laulu [lauluId=" + lauluId + ", nimi=" + nimi + ", sanat=" + sanat + ", savel=" + savel + ", ohje="
				+ ohje + ", pakollinen=" + pakollinen + "]";
	}
	
}
