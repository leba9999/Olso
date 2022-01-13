package kilpailu;

/**
* @author Leevi Koskinen 15.9.2021
*/

public class KilpailuMain {

	private static int KILPAILIJALKM = 8;
	
	public static void main(String[] args) {
		Kilpajuoksija[] juoksijat = new Kilpajuoksija[KILPAILIJALKM];
		
		for(int i = 0; i < juoksijat.length; i++) {
			juoksijat[i] = new Kilpajuoksija();
			juoksijat[i].start();
		}
		
		int kaatunutKilpailija = (int)(Math.random() * (8 - 1)); // Satunnainen juoksija joka kaatuu
		int kaatunutAika = (int)(Math.random() * (20 - 1) + 1); // Kaatumisessa kuluva aika
		int juostuMatka = (int)(Math.random() * (200 - 50) + 50); // Juostu matka ennen kaatumista
		System.out.println("Kilpailija: " + (kaatunutKilpailija + 1) + ", kaatuu kun matkaa kulunut:" + juostuMatka + "m, maassa:" + kaatunutAika + "s");
		while(juoksijat[kaatunutKilpailija].getJuostuMatka() < juostuMatka) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Kaadetaan juoksija
		juoksijat[kaatunutKilpailija].kaadu(kaatunutAika);
		// Odotellaan
		try {
			Thread.sleep(kaatunutAika*1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// Nostetaan juoksija
		juoksijat[kaatunutKilpailija].nouse();
		
		for(int i = 0; i < juoksijat.length; i++) {
			try {
				juoksijat[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Kilpailu on ohi, onnea voittajalle.");
	}
}
