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
	private String juomapeliNimi;
	private String tarvikkeet;
	@Column(columnDefinition = "varchar(1400)")
	private String juomapeliSaannot;
	
	
	public Juomapeli() {
		super();
		
	}
	
	public Juomapeli(String juomapeliNimi, String juomapeliSaannot) {
		super();
		this.juomapeliNimi = juomapeliNimi;
		this.juomapeliSaannot = juomapeliSaannot;
	}

	public Juomapeli(String juomapeliNimi, String tarvikkeet, String juomapeliSaannot) {
		super();
		this.juomapeliNimi = juomapeliNimi;
		this.tarvikkeet = tarvikkeet;
		this.juomapeliSaannot = juomapeliSaannot;
	}

	public Long getJuomapeliId() {
		return juomapeliId;
	}

	public void setJuomapeliId(Long juomapeliId) {
		this.juomapeliId = juomapeliId;
	}

	public String getJuomapeliNimi() {
		return juomapeliNimi;
	}

	public void setJuomapeliNimi(String juomapeliNimi) {
		this.juomapeliNimi = juomapeliNimi;
	}

	public String getTarvikkeet() {
		return tarvikkeet;
	}

	public void setTarvikkeet(String tarvikkeet) {
		this.tarvikkeet = tarvikkeet;
	}

	public String getJuomapeliSaannot() {
		return juomapeliSaannot;
	}

	public void setJuomapeliSaannot(String juomapeliSaannot) {
		this.juomapeliSaannot = juomapeliSaannot;
	}

	@Override
	public String toString() {
		return "Juomapeli [juomapeliId=" + juomapeliId + ", nimi=" + juomapeliNimi + ", tarvikkeet=" + tarvikkeet + ", saannot="
				+ juomapeliSaannot + "]";
	}
	
		
}
