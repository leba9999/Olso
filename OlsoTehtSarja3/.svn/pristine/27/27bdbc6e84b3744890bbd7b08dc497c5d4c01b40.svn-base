
package suorakulmiot;
/**
 *
 * @author Leevi Koskinen 30.8.2021
 */

// NaytonSuorakulmio perii Suorakulmio luokan
// Luokalla NaytonSuorakulmio luodaan suorakulmio ja voidaan testata
// mahtuuko suorakulmio kokonaan näytölle tai halutun kokoiselle alueelle.

public class NaytonSuorakulmio extends Suorakulmio {
	private int x;
	private int y;
	NaytonSuorakulmio(int x, int y, int width, int height){
		super(width, height);
		this.x = x;
		this.y = y;
		
	}
	public boolean mahtuu(int width, int height) {
		if(width - this.x >= super.getLeveys() && height - this.y >= super.getKorkeus()) {
			return true;
		}
		return false;
	}
    @Override
    public String toString() {
    	return "x=" + this.x + ", y=" + this.y + ", "+ super.toString();
    }
}
