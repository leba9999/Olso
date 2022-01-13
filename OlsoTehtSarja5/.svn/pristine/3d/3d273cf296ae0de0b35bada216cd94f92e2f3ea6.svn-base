
import saikeet.Kilpajuoksija;

/**
* @author Leevi Koskinen 11.9.2021
*/

public class KilpailuMain {

	private static int KILPAILIJALKM = 8;
	
	public static void main(String[] args) {
		Kilpajuoksija[] juoksijat = new Kilpajuoksija[KILPAILIJALKM];
		
		for(int i = 0; i < juoksijat.length; i++) {
			juoksijat[i] = new Kilpajuoksija();
			juoksijat[i].start();
		}
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
