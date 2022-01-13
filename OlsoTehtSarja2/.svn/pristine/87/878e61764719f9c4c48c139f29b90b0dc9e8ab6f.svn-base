package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Leevi Koskinen 25.8.2021
 */
public class Kahvila {

    // Esittele instanssimuuttuja valikoiman ja tilausten tallettamiseksi (ArrayList)
	private Valikoima valikoima;
	private String nimi;
	private ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>(); 

    // Ohjelmoi yhden parametrin konstruktori
	public Kahvila(Valikoima valikoima) {
		this.valikoima = valikoima;
		this.nimi = null;
	}
	// Oma konstruktori!!!!
	public Kahvila(String nimi, Valikoima valikoima) {
		this.valikoima = valikoima;
		this.nimi = nimi;
	}
	public String getNimi() {
		return this.nimi;
	}
	public Valikoima getValikoima() {
		return this.valikoima;
	}
	public void setValikoima(Valikoima valikoima) {
		this.valikoima = valikoima;
	}
    // Ohjelmoi lisääTilaus()
	public void lisääTilaus(Tilaus tilaus) {
		tilaukset.add(tilaus);
	}

    // Ohjelmoi toString(), joka palauttaa merkkijonoesityksen KAhvila-oliosta
    @Override
	public String toString() {
    	String value = "";
    	if(this.nimi != null) {
    		value += "Kahvila " + this.nimi + " tilaukset:\n";
    	}
    	double summa = 0;
		for(int i = 0; i < tilaukset.size(); i++) {
			value += "\nTilaus "+ (i + 1) +":\n" + tilaukset.get(i) + "Hinta: " + tilaukset.get(i).annaLoppusumma() + "€\n";
			summa += tilaukset.get(i).annaLoppusumma();
		}
		return value + "\nTilauksien yht.hinta: " + summa + "€\n---------------------------";
	}
}
