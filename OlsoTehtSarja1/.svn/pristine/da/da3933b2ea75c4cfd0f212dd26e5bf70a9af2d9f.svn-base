import pokerikadet.Kasi;
import pokerikadet.Pakka;

/**
*
* @author Leevi Koskinen 23.8.2021
*/

public class Main {

    public static void main(String[] args) {

    	// Luo pakka
    	Pakka pakka = new Pakka();
    	Kasi kasi;
    	String[] saatukasi = {"Väri", "Suora", "Värisuora"};
    	do {
        	// Sekoita pakka
        	pakka.sekoita();
        	// Jaa käsi
        	Kasi jaettuKasi = new Kasi(pakka);
        	// Näytä (tulosta) käsi
            System.out.println(jaettuKasi);
        	// Tarkasta onko väri
            kasi = jaettuKasi;
    	} while(kasi.annaArvo() != 1 && kasi.annaArvo() != 2 && kasi.annaArvo() != 3);
        System.out.println("Saatiin " + saatukasi[kasi.annaArvo()-1] + "! sekoitus määrällä: " + kasi.getMaara());
    }
}