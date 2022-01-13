package pokerikadet;
/**
*
* @author Leevi Koskinen 23.8.2021
*/
import java.util.Arrays;

public class Kasi {
	
    final static int EIVÄRI = 0, EISUORA = 0, SUORA = 1, VÄRI = 2, VÄRISUORA = 3;
    // Näiden näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista muodossa Luokka.tunnus esim. Käsi.SUORA
    private static int MAARA = 0;
    // Esittele instanssimuuttujat
    private Kortti[] kasi;
    
    // Kirjoita konstruktori, joka saa parametrina Pakka-olion
    public Kasi(Pakka pakka){
    	this.kasi = new Kortti[5];
    	for(int i = 0; i < this.kasi.length; i++) {
        	this.kasi[i] = pakka.annaKortti();
    	}
    	MAARA++;
    }
    public Kasi(Kortti[] kortit){
    	this.kasi = kortit;
    	MAARA++;
    }
    // Kirjoita konstruktori, joka saa parametrina kortit
    // Kirjoita toteutus metodille annaArvo()
    public int annaArvo() {
    	boolean varisuora = true;
    	int value = VÄRI;
    	int[] kortit = new int[5];
    	// Selvitetään onko väri ja valmistellaan suoran tarkistusta
    	for(int i = 0; i < this.kasi.length; i++) {
    		kortit[i] = this.kasi[i].getArvo();
    		if(this.kasi[0].getMaa() != this.kasi[i].getMaa()) {
    			varisuora = false;
    			value = SUORA;
    		}
    	}
    	// Selvitetään onko suora
    	Arrays.sort(kortit);
		if(kortit[0] == 1 && kortit[4] == 13) {
	    	kortit[0] = 14;
		}
    	Arrays.sort(kortit);
    	for(int i = 1; i < this.kasi.length; i++) {
    		if(kortit[i-1] != kortit[i]-1) {
    			varisuora = false;
    			if(value == SUORA) {
        			value = EISUORA;
    			}
    		}
    	}
    	if(varisuora) {
        	return VÄRISUORA;
    	}
        return value;
    }
    // get metodi static MAARA:lle
    public static int getMaara() {
    	return MAARA;
    }

    // Kirjoita toString()
    @Override
    public String toString() {
    	String kortit = "";
    	for(int i = 0; i < this.kasi.length; i++) {
    		kortit += this.kasi[i].toString();
    		if(this.kasi.length - 1 > i) {
    			kortit += ", ";
    		}
    	}
    	return kortit;
    }
}
