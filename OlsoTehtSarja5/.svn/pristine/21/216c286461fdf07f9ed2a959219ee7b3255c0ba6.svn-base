
import saikeet.KilpajuoksijaP;

/**
* @author Leevi Koskinen 11.9.2021
*/

public class KilpailuMainP {

	private static int KILPAILIJALKM = 8;
	
	public static void main(String[] args) {
		KilpajuoksijaP[] juoksijat = new KilpajuoksijaP[KILPAILIJALKM];
		
		for(int i = 0; i < juoksijat.length; i++) {
			juoksijat[i] = new KilpajuoksijaP();
			juoksijat[i].start();
		}
		for(int i = 0; i < juoksijat.length; i++) {
			try {
				juoksijat[i].join();
				System.out.println("Juoksija: " + juoksijat[i].getNumero() + ", nano aika:" + juoksijat[i].getAika() + ", Prioriteetti:" + juoksijat[i].getPriority());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Kilpailu on ohi, onnea voittajalle.");
	}
}
