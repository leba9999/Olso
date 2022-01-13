package sharedXY;

/**
* @author Leevi Koskinen 13.9.2021
*/

public class SwappaajaMain {
	 public static void main(String args[]) {
		 final int MAARA = 10;
		 SharedXY sharedXY = new  SharedXY(2, 6);
		 Swappaaja[] swappaajat = new Swappaaja[MAARA];
		 for(int i = 0; i < swappaajat.length; i++) {
			 swappaajat[i] = new Swappaaja(sharedXY);
			 swappaajat[i].start();
		 }
		 for(int i = 0; i < swappaajat.length; i++) {
			 try {
				swappaajat[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
}