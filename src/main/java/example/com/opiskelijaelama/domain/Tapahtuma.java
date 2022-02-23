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
	
	private String tapahtumaNimi;
	@Column(columnDefinition = "varchar(690)")
	private String tapahtumaKuvaus;
	@Column(columnDefinition = "varchar(1500)")
	private String tapahtumaSaannot;
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

	public String getTapahtumaNimi() {
		return tapahtumaNimi;
	}

	public void setTapahtumaNimi(String tapahtumaNimi) {
		this.tapahtumaNimi = tapahtumaNimi;
	}
	
	public String getTapahtumaKuvaus() {
		return tapahtumaKuvaus;
	}

	public void setTapahtumaKuvaus(String tapahtumaKuvaus) {
		this.tapahtumaKuvaus = tapahtumaKuvaus;
	}

	public String getTapahtumaSaannot() {
		return tapahtumaSaannot;
	}

	public void setTapahtumaSaannot(String tapahtumaSaannot) {
		this.tapahtumaSaannot = tapahtumaSaannot;
	}

	public int getHenkilomaara() {
		return henkilomaara;
	}

	public void setHenkilomaara(int henkilomaara) {
		this.henkilomaara = henkilomaara;
	}

	@Override
	public String toString() {
		return "Tapahtuma [tapahtumaId=" + tapahtumaId + ", nimi=" + tapahtumaNimi + ", kuvaus=" + tapahtumaKuvaus + ", saannot="
				+ tapahtumaSaannot + ", henkilomaara=" + henkilomaara + "]";
	}
}



