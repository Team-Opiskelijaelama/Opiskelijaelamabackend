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
@JsonIgnoreProperties(value = { "rastikierros" })
@Table(name="TEHTAVA")
public class Tehtava {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tehtavaId;
	private String tehtavanimi;
	private String tehtavakuvaus;
	
	@ManyToMany(mappedBy="tehtavalista", fetch = FetchType.LAZY)
	private List<Rastikierros> rastikierrokset = new ArrayList<Rastikierros>();

	public Tehtava() {}

	public Tehtava(String tehtavanimi, String tehtavakuvaus) {
		super();
		this.tehtavanimi = tehtavanimi;
		this.tehtavakuvaus = tehtavakuvaus;
	}

	public Long getTehtavaId() {
		return tehtavaId;
	}

	public void setTehtavaId(Long tehtavaId) {
		this.tehtavaId = tehtavaId;
	}

	public String getTehtavanimi() {
		return tehtavanimi;
	}

	public void setTehtavanimi(String tehtavanimi) {
		this.tehtavanimi = tehtavanimi;
	}

	public String getTehtavakuvaus() {
		return tehtavakuvaus;
	}

	public void setTehtavakuvaus(String tehtavakuvaus) {
		this.tehtavakuvaus = tehtavakuvaus;
	}

	public List<Rastikierros> getRastikierrokset() {
		return rastikierrokset;
	}

	public void setRastikierrokset(List<Rastikierros> rastikierrokset) {
		this.rastikierrokset = rastikierrokset;
	}
	
	//Mahdollisuudet lisätä ja poistaa rastikierroksia
	public void addRastikierros(Rastikierros rastikierros) {
		rastikierrokset.add(rastikierros);
		rastikierros.getTehtavalista().add(this);
	}
			
	public void removeRastikierros(Rastikierros rastikierros) {
		rastikierrokset.remove(rastikierros);
		rastikierros.getTehtavalista().remove(this);
	}

	@Override
	public String toString() {
		return "Tehtava [tehtavaId=" + tehtavaId + ", tehtavanimi=" + tehtavanimi + ", tehtavakuvaus=" + tehtavakuvaus
				+ "]";
	};
	
	
}