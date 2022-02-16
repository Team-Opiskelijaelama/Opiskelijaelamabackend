package example.com.opiskelijaelama.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TAPAHTUMA_TYYPPI")
@Table(name="TAPAHTUMA")
public class Tapahtuma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tapahtumaId;
	
	private String nimi;
	@Column(columnDefinition = "varchar(690)")
	private String kuvaus;
	@Column(columnDefinition = "varchar(1500)")
	private String saannot;
	private int henkilomaara;
	
	
	public Tapahtuma() {
		super();
	}

	public Long getTapahtumaId() {
		return tapahtumaId;
	}

	public void setTapahtumaId(Long tapahtumaId) {
		this.tapahtumaId = tapahtumaId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public String getSaannot() {
		return saannot;
	}

	public void setSaannot(String saannot) {
		this.saannot = saannot;
	}

	public int getHenkilomaara() {
		return henkilomaara;
	}

	public void setHenkilomaara(int henkilomaara) {
		this.henkilomaara = henkilomaara;
	}

	@Override
	public String toString() {
		return "Tapahtuma [tapahtumaId=" + tapahtumaId + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", saannot="
				+ saannot + ", henkilomaara=" + henkilomaara + "]";
	}
}



