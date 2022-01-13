
package suorakulmiot;
/**
 *
 * @author Leevi Koskinen
 */

public class Testi {

    public static void main(String[] args) {

    	NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(225, 120, 800, 30);
    	System.out.println(suorakulmio);
    	if(suorakulmio.mahtuu(1024, 768)) {
    		System.out.println("Suorakulmio mahtuu.");
    	} else {
    		System.out.println("Suorakulmio ei mahdu!!");
    	}
    	Suorakulmio kuolmikas = new Suorakulmio(80, 40);
		System.out.println(kuolmikas + " pinta-ala:" + kuolmikas.ala());
    }
}
