package valtiot;

/**
* @author Leevi Koskinen 7.9.2021
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValtioMain {

	public static void main(String[] args) {

		// Valtioiden käsittelyssä tarvittavat muuttujat ja
		// HashMap-olio Valtio-olioiden tallentamiseksi
		// Valtio valtio;
		String nimi;
		String pääkaupunki;
		int asukasluku = 0;
		HashMap<String, Valtio> valtiot = new HashMap<>();
		final String TIEDOSTONIMI = "valtiot.dat";
		
		Scanner näppis = new Scanner(System.in);
		
		// Jos tiedosto on olemassa, lue HashMap sieltä 
		
		valtiot = TiedostonKasittely.lueTiedosto(TIEDOSTONIMI);
		if (valtiot == null) {
			valtiot = new HashMap<>();
		}
		// Lue valtioiden tietoja ja lisää valtioita HashMapiin, 
		// kunnes syötteenä annetaan tyhjä 
		do {
			System.out.println("Syötä valtion nimi:");
			nimi = näppis.nextLine();
			if(!valtiot.containsKey(nimi)) {
				if(nimi.length() != 0) {
					System.out.println("Syötä valtion pääkaupunki:");
					pääkaupunki = näppis.nextLine();
					boolean kelvollinenLuku = false;
					do {
						try {
							System.out.println("Syötä valtion asukasluku:");
							asukasluku = Integer.parseInt(näppis.nextLine());
							kelvollinenLuku = true;
						} catch(NumberFormatException e) {
							System.out.println("Syöttämäsi luku ei ole kokonaisluku");
						}
					} while(!kelvollinenLuku);
					valtiot.put(nimi, new Valtio(nimi, pääkaupunki, asukasluku));
				} 
			} else {
				System.out.println("Syöttämäsi valtio on jo olemassa!");
			}
		} while (nimi.length() != 0);
		
        // Tulosta HashMapin sisältö, käytä for-each- rakennetta
		System.out.println("HashMapissa nyt seuraavat valtiot:");
	    for (Map.Entry<String, Valtio> valtio : valtiot.entrySet()) {
	        System.out.println(valtio);
	      }

		// Kirjoita HashMap tiedostoon
	    TiedostonKasittely.kirjoitaTiedosto(TIEDOSTONIMI, valtiot);
	  
		näppis.close();
	}
}
