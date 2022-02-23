package example.com.opiskelijaelama.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@DiscriminatorValue("G")
@Table(name="GAMBINAKOKOUS")
public class Gambinakokous extends Tapahtuma{
	
	private String puheenjohtaja;
	private String sihteeri; 
	private String poytakirja;
	
	public Gambinakokous() {
		super();
		this.setTapahtumaNimi("Gambinakokous");
		this.setTapahtumaKuvaus("Kerää kaverit kokoon ja juokaa kokonainen Gambina-pullo tyhjäksi. Tästä kokouksesta tulee täyttää pöytäkirjapohjan mukainen kokouspöytäkirja ja kokouksella tulee olla puheenjohtaja ja sihteeri. ");
		this.setHenkilomaara(5);
		this.setTapahtumaSaannot("Vain pullokädessä saa pitää puheenvuoroja. Kokoukseen varattu pullo tulee tyhjentää kokouksen aikana. Puheenjohtaja ottaa ensimmäisen huikan. ");
	}

	public Gambinakokous(String puheenjohtaja, String sihteeri, String poytakirja) {
		super();
		this.setPuheenjohtaja(puheenjohtaja);
		this.setSihteeri(sihteeri);
		this.setPoytakirja(poytakirja);
	}
	
	
	public String getPuheenjohtaja() {
		return puheenjohtaja;
	}
	
	public void setPuheenjohtaja(String puheenjohtaja) {
		this.puheenjohtaja = puheenjohtaja;
	}
	
	public String getSihteeri() {
		return sihteeri;
	}
	
	public void setSihteeri(String sihteeri) {
		this.sihteeri = sihteeri;
	}
	
	public String getPoytakirja() {
		return poytakirja;
	}
	
	public void setPoytakirja(String poytakirja) {
		this.poytakirja = poytakirja;
	} 
	
	
	@Override
	public String toString() {
		return "Gambinakokous [getPuheenjohtaja()=" + 
	getPuheenjohtaja() + ", getSihteeri()=" + getSihteeri() + ", getPoytakirja()=" + getPoytakirja() +"]";
		
	}

}
