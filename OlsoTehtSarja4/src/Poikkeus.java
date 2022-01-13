import java.util.Scanner;

/**
* @author Leevi Koskinen 6.9.2021
*/

public class Poikkeus {

	public static void main(String[] args) {

	    System.out.println("Tehtävä 1: Poikkeuksen testaaminen");
		Scanner scan = new Scanner(System.in);
		String syöttö;
	    while(true) {
		    System.out.println("Anna ikäsi:");
		    syöttö = scan.nextLine();
		    try {
			    System.out.println("Vuoden päästä olet jo " + (Integer.parseInt(syöttö) + 1) + "-vuotias.");
			    break;
		    } catch(NumberFormatException e) {
			    System.out.println("Antamasi ikä " + syöttö + " ei ole kelvollinen");
		    } catch(Exception e) {
			    e.printStackTrace();
		    }
	    }
	}
}
