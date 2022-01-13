package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Leevi Koskinen 25.8.2021
 */
public class Tilaus {

    // Esittele ArrayList tilausrivien tallettamiseksi
	private ArrayList<Tilausrivi> tilausrivit = new ArrayList<Tilausrivi>(); 
	
    // Ohjelmoi lisääRiviTilaukseen()
	public void lisääRivi(Tilausrivi tilausrivi) {
		tilausrivit.add(tilausrivi);
	}

	// Ohjelmoi annaLoppusumma()
	public double annaLoppusumma() {
		double summa = 0;
		for(int i = 0; i < tilausrivit.size(); i++) {
			summa += tilausrivit.get(i).annaSumma();
		}
		return summa;
	}
	
    // Ohjelmoi toString, joka palauttaa merkkijonoesityksen yhdestä Tilaus-oliosta
    @Override
	public String toString() {
    	String value = "";
		for(int i = 0; i < tilausrivit.size(); i++) {
			value += tilausrivit.get(i) + "\n";
		}
		return value;
	}

}
