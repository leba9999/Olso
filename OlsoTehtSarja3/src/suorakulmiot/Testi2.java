
package suorakulmiot;
/**
 *
 * @author Leevi Koskinen
 */

public class Testi2 {

    public static void main(String[] args) {

    	IKuvio suorakulmio = new NaytonSuorakulmio(225, 120, 800, 30);
    	System.out.println(suorakulmio);
    	if(((NaytonSuorakulmio) suorakulmio).mahtuu(1024, 768)) {
    		System.out.println("Suorakulmio mahtuu.");
    	} else {
    		System.out.println("Suorakulmio ei mahdu!!");
    	}
		System.out.println(suorakulmio + " pinta-ala:" + suorakulmio.ala());
    }
}
