package kahvila;
import java.util.ArrayList;
/**
 *
 * @author Leevi Koskinen 25.8.2021
 */
public class Valikoima {
	
    // Esittele ArrayList tuotteiden tallettamiseksi
	private ArrayList<Tuote> tuotteet = new ArrayList<Tuote>(); 
    // Ohjelmoi getTuote()
	public Tuote getTuote(int tuotenumero) {
		for(int i = 0; i < tuotteet.size(); i++) {
			if(tuotteet.get(i).getTuotenumero() == tuotenumero) {
				return tuotteet.get(i);
			}
		}
		return null;
	}
	public Tuote getTuote(String nimi) {
		for(int i = 0; i < tuotteet.size(); i++) {
			// tuotteet.get(i).getNimi() == nimi on väärin pitää kutsua joko contains tai compareto metodeja ennemin
			// == kysyy vain osoittaako nimi samaan paikkaan muistissa kuin tuotteet.get(i).getNimi()
			if(tuotteet.get(i).getNimi().contains(nimi)) {
				return tuotteet.get(i);
			}
		}
		return null;
	}
    // Ohjelmoi lisääTuote()
	public void lisääTuote(Tuote tuote) {
		if(!tuotteet.contains(tuote)) {
			tuotteet.add(tuote);
		}
	}
    // Ohjelmoi poistaTuote()
	public boolean poistaTuote(int tuotenumero) {
		for(int i = 0; i < tuotteet.size(); i++) {
			if(tuotteet.get(i).getTuotenumero() == tuotenumero) {
				tuotteet.remove(i);
				return true;
			}
		}
		return false;
	}
    // Poistettava Tuote-olio pitää etsiä listasta tuotenumerolla,
    // koska poistojen jälkeen tuotenumero != listan indeksi

    // Ohjelmoi toString(), joka on merkkijonoesitys Valikoima-oliosta (eli kaikista tuotteista)
    @Override
	public String toString() {
    	String value = "";
		for(int i = 0; i < tuotteet.size(); i++) {
			value += tuotteet.get(i) + "\n";
		}
		return value;
	}
}
