package model;

/**
 * @author Leevi Koskinen
 */

public class Valuutta {
	// Nämä rajoitteet tulevat tietokannan schemasta
	public final int TUNNUS_MAX = 3;
	public final int NIMI_MAX = 50;
	
	private String tunnus;
	private double kurssi;
	private String nimi;
	
	public Valuutta() {
		
	}
	
	public Valuutta(String tunnus, double kurssi, String nimi) {
		this.setNimi(nimi);
		this.setTunnus(tunnus);
		this.setVaihtokurssi(kurssi);
	}

	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		if(tunnus.length() > TUNNUS_MAX) {
			tunnus = tunnus.substring(0,TUNNUS_MAX);
		}
		this.tunnus = tunnus.toUpperCase();
	}
	public double getVaihtokurssi() {
		return kurssi;
	}
	public void setVaihtokurssi(double kurssi) {
		this.kurssi = kurssi;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		if(nimi.length() > NIMI_MAX) {
			nimi = nimi.substring(0,NIMI_MAX);
		}
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Valuutta tunnus=" + tunnus + ", kurssi=" + kurssi + ", nimi=" + nimi;
	}
	
	
}
