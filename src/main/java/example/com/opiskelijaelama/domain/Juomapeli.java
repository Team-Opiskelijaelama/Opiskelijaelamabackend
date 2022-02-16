package example.com.opiskelijaelama.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Juomapeli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long juomapeliId;
	private String nimi;
	private String tarvikkeet;
	@Column(columnDefinition = "varchar(1400)")
	private String saannot;
	
	
	public Juomapeli() {
		super();
		
	}
	
	public Juomapeli(String nimi, String saannot) {
		super();
		this.nimi = nimi;
		this.saannot = saannot;
	}

	public Juomapeli(String nimi, String tarvikkeet, String saannot) {
		super();
		this.nimi = nimi;
		this.tarvikkeet = tarvikkeet;
		this.saannot = saannot;
	}

	public Long getJuomapeliId() {
		return juomapeliId;
	}

	public void setJuomapeliId(Long juomapeliId) {
		this.juomapeliId = juomapeliId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTarvikkeet() {
		return tarvikkeet;
	}

	public void setTarvikkeet(String tarvikkeet) {
		this.tarvikkeet = tarvikkeet;
	}

	public String getSaannot() {
		return saannot;
	}

	public void setSaannot(String saannot) {
		this.saannot = saannot;
	}

	@Override
	public String toString() {
		return "Juomapeli [juomapeliId=" + juomapeliId + ", nimi=" + nimi + ", tarvikkeet=" + tarvikkeet + ", saannot="
				+ saannot + "]";
	}
	
		
}
