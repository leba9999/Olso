package kahvila;

/**
 *
 * @author Leevi Koskinen 25.8.2021
 */
public class Tuote {

    // Esittele instanssimuuttujat
	private int tuotenumero;
	private String nimi;
	private double hinta;
	
    // Esittele staattinen muuttuja seuraavan vapaan tuotenumeron ylläpitämiseksi
	private static int seuraavaVapaaTuoteNumero = 1;

    // Ohjelmoi staattinen metodi alustaSeuraavaVapaaTuotenumero()
	public static void alustaSeuraavaVapaaTuotenumero() {
		seuraavaVapaaTuoteNumero = 1;
	}
    // Ohjelmoi kahden parametrin konstruktori
	public Tuote(String nimi, double hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
		this.tuotenumero = seuraavaVapaaTuoteNumero;
		seuraavaVapaaTuoteNumero++;
	}

    // Ohjelmoi toString(), joka palauttaa merkkijonoesityksen Tuote-oliosta.
	public String getNimi() {
		return this.nimi;
	}
	
    // Ohjelmoi getHinta()
	public double getHinta() {
		return this.hinta;
	}
	
    // Ohjelmoi getTuotenumero()
	public int getTuotenumero() {
		return this.tuotenumero;
	}
	
    // Ohjelmoi toString(), joka palauttaa merkkijonoesityksen Tuote-oliosta.
    @Override
	public String toString() {
		return this.tuotenumero + ": " + this.nimi + ", " + this.hinta + "€";
	}
}
