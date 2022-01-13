import saikeet.Juoksija;

/**
 * @author Leevi Koskinen 11.9.2021
 */

public class JuoksijaMain {
	public static void main(String[] args) {
		Juoksija juoksija = new Juoksija();
		juoksija.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		juoksija.lopeta();
		System.out.println("Kierrosten määrä: " + juoksija.getKierrokset());	
	}
}
