package kahvila;

/**
 *
 * @author Leevi Koskinen 25.8.2021
 */
public class Tilausrivi {

    // Esittele instanssimuuttujat
    private Tuote tuote;
    private int kappalemäärä;
    
    // Ohjelmoi kolmen parametrin konstruktori 
	public Tilausrivi(Valikoima valikoima, int tuotenumero, int määrä) {
		this.tuote = valikoima.getTuote(tuotenumero);
		this.kappalemäärä = määrä;
	}
	
    // Ohjelmoi annaSumma(
	public double annaSumma() {
		return this.tuote.getHinta() * this.kappalemäärä;
	}
    // Ohjelmoi toString(), joka palautta merkkijonoesityksen Tilausrivi-oliosta
    @Override
	public String toString() {
		return tuote + ", kpl: " + this.kappalemäärä + ", yht.Hinta: " + annaSumma() + "€";
	}
}
