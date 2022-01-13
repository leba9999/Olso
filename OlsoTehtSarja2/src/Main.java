import kahvila.*;
import java.util.Scanner;
/**
 *
 * @author Leevi Koskinen 25.8.2021
 */

public class Main {

	private static final Scanner scan = new Scanner(System.in);
	
	private static Tuote addTuote() {
    	double hinta = 0;
    	boolean notParseable = false;
    	String nimi = "";
    	
    	System.out.println("Syötä uuden tuotteen nimi: ");
        nimi = scan.nextLine();
    	System.out.println("Syötä tuotteen hinta: ");
    	do {
    		notParseable = false;
            String annettuHinta = scan.nextLine();
            // Varmistetaan pisteen ja pilkun toimivuus. Eli numerot voi erotella molemmilla [.][,]
        	for(int i = 0; i < annettuHinta.length(); i++) {
            	if(annettuHinta.toCharArray()[i] == ',') {
            		char[] newString = annettuHinta.toCharArray();
            		newString[i] = '.';
            		annettuHinta = new String(newString);
            	}
        	}
        	try {
                hinta = Double.parseDouble(annettuHinta);
        	} catch(Exception e) {
            	System.out.println("Hintaa ei pystynyt muuntamaan. Varmista että syötit vain numeroita ja [. ,]");
        		notParseable = true;
        	}
    	} while(notParseable);
    	Tuote tuote = new Tuote(nimi, hinta);
        return tuote;
	}
	
    public static void main(String[] args) {

    // Esittele tarvittavat muuttujat.
    	Tuote[] tuotteet = new Tuote[3];
    	Valikoima valikoima = new Valikoima();
    // Luo kolme tuotetta.
    	tuotteet[0] = new Tuote("Munkki", 0.30);
    	tuotteet[1] = new Tuote("Kahvi", 0.80);
    	tuotteet[2] = new Tuote("Sunkki", 5.40);

    // Lisää ne valikoimaan.
    	for(int i = 0; i < tuotteet.length; i++) {
        	valikoima.lisääTuote(tuotteet[i]);
    	}
    // Tulosta valikoima.
    	System.out.println("Valikoima: ");
    	System.out.println(valikoima);
    // Poista siitä yksi tuote.
    	valikoima.poistaTuote(3);
    // Tulosta muuttunut valikoima.
    	System.out.println("Uusi valikoima: ");
    	System.out.println(valikoima);
    	
    	Kahvila sotku = new Kahvila("Sotku", valikoima);
    	
    // Luo tilaus.
    	Tilaus tilaus = new Tilaus();
    // Luo kaksi tilausriviä.
    	Tilausrivi Munkit = new Tilausrivi(sotku.getValikoima(), 1, 4);
    	Tilausrivi Kahvit = new Tilausrivi(sotku.getValikoima(), 2, 2);
    // Lisää tilausrivit tilaukseen.
    	tilaus.lisääRivi(Munkit);
    	tilaus.lisääRivi(Kahvit);
    // Lisää tilaus kahvilan tilauslistaan.
    	sotku.lisääTilaus(tilaus);
    	
    // Luo toinenkin tilaus tilausriveineen.
    	Tilaus tilaus_2 = new Tilaus();
    	Tilausrivi Munkki = new Tilausrivi(sotku.getValikoima(), 1, 1);
    	Tilausrivi Kahvi = new Tilausrivi(sotku.getValikoima(), 2, 1);
    	tilaus_2.lisääRivi(Munkki);
    	tilaus_2.lisääRivi(Kahvi);
    	sotku.lisääTilaus(tilaus_2);

    // Tulosta kaikki kahvilan tilaukset.
    	System.out.println(sotku);
    	
    	// Tehtävä 7:
    	int value = 0;
    	do {
        	System.out.println("Kahvilan valikoima ja tilaus järjestelmä!\n");
        	System.out.println("Lisää tuote syötämällä numero 1");
        	System.out.println("Poista tuote syötämällä numero 2");
        	System.out.println("Tee tilaus syötämällä numero 3");
        	System.out.println("Lopeta ohjelma syötämällä numero 0");
            try {
                String answer = scan.nextLine();
            	value = Integer.parseInt(answer);
                if(value == 1) {
                	Tuote tuote = addTuote();
                	System.out.println("Lisätään " + tuote);
                	valikoima.lisääTuote(tuote);
                	sotku.setValikoima(valikoima);
                	System.out.println("Nykyinen valikoima: \n" +  sotku.getValikoima());
                } else if(value == 2) {
                	System.out.println("Poistettavan tuotteen tuotenumero: ");
                	int tuotenumero = Integer.parseInt(scan.nextLine());
                	System.out.println("Poistetaan tuote " + valikoima.getTuote(tuotenumero));
                	if(valikoima.poistaTuote(tuotenumero)) {
                    	System.out.println("Tuote poistettu!");
                	} else {
                    	System.out.println("Tuotetta ei pystytty poistamaan!");
                	}
                	sotku.setValikoima(valikoima);
                	System.out.println("Nykyinen valikoima: \n" + sotku.getValikoima());
                } else if(value == 3) {
                	Tilaus Kahvilantilaus = new Tilaus();
                	do {
	                	System.out.println("Valikoima: \n" + sotku.getValikoima());
	                	System.out.println("Lisää tuote tilaukseen antamalla tuotenumero:");
	                    String tuote = scan.nextLine();
	                    int tuotenumero = Integer.parseInt(tuote);
	                	System.out.println("Anna kpl määrä:");
	                    String maaraS = scan.nextLine();
	                    int maara = Integer.parseInt(maaraS);
	                	Tilausrivi tilausrivi = new Tilausrivi(sotku.getValikoima(), tuotenumero, maara);
	                	Kahvilantilaus.lisääRivi(tilausrivi);
	                	System.out.println("Lisää tilausrivi syöttämällä numero 1:");
	                	System.out.println("Lopeta tilausrivien syöttö syöttämällä numero 2:");
	                    String vastaus = scan.nextLine();
	                    value = Integer.parseInt(vastaus);
                	} while(value != 2);
                	sotku.lisääTilaus(Kahvilantilaus);
                    // Tulosta kaikki kahvilan tilaukset.
                	System.out.println(sotku);
                }
            }catch(Exception e) {
            	System.out.println("Tuntematon toiminto");
            	value = -1;
            }
    	}while(value != 0);
    	scan.close();
    }
}
