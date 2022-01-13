package valtiot;

import java.io.Serializable;

/**
* @author Leevi Koskinen 6.9.2021
*/

public class Valtio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nimi;
	private String pääkaupunki;
	private int asukasluku;

	public Valtio() {
		
	}
	public Valtio(String nimi, String pääkaupunki, int asukasluku) {
		this.nimi = nimi;
		this.pääkaupunki = pääkaupunki;
		this.asukasluku = asukasluku;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setPääkaupunki(String pääkaupunki) {
		this.pääkaupunki = pääkaupunki;
	}
	public void setAsukasluku(int asukasluku) {
		this.asukasluku = asukasluku;
	}
	public String getNimi() {
		return this.nimi;
	}
	public String getPääkaupunki() {
		return this.pääkaupunki;
	}
	public int getAsukasluku() {
		return this.asukasluku;
	}
    @Override
	public String toString() {
		return String.format("%-10s %-10s %-10d", nimi, pääkaupunki, asukasluku);
	}
	
}
