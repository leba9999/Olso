package model;

public class Valuutta {
	private String nimi;
	private double vaihtokurssi;
	public Valuutta(String nimi, double vaihtokurssi) {
		this.nimi = nimi;
		this.vaihtokurssi = vaihtokurssi;
	}
	public String getNimi() {
		return nimi;
	}
	public double getVaihtokurssi() {
		return vaihtokurssi;
	}
	public void setVaihtokurssi(double vaihtokurssi) {
		this.vaihtokurssi = vaihtokurssi;
	}
	
}
