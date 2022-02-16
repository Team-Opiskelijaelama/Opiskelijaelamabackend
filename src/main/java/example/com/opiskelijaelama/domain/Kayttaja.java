package example.com.opiskelijaelama.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kayttajaId;
	
    @Column(name = "nimi", nullable = false, unique = true)
	private String nimi;
	private String rooli;
	private String salasana;
	
	
	
	public Kayttaja() {
		super();
	}

	public Kayttaja(String nimi, String rooli, String salasana) {
		super();
		this.nimi = nimi;
		this.rooli = rooli;
		this.salasana = salasana;
	}

	public long getKayttajaId() {
		return kayttajaId;
	}

	public void setKayttajaId(long kayttajaId) {
		this.kayttajaId = kayttajaId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	@Override
	public String toString() {
		return "Käyttäjä [kayttajaId=" + kayttajaId + ", nimi=" + nimi + ", rooli=" + rooli + ", salasana=" + salasana
				+ "]";
	}
}
