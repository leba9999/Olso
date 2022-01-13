
package suorakulmiot;
/**
 *
 * @author Leevi Koskinen 30.8.2021
 */
 
// Suorakulmio luokka toteuttaa IKuvion
// Suorakulmio sisältää jonkin suorakulmion leveyden ja korkeuden

public class Suorakulmio implements IKuvio {
	private int width;
	private int height;
	
	public Suorakulmio(){
		
	}
	public Suorakulmio(int width, int height) {
		this.width = width;
		this.height = height;
	}
    public void setLeveys(int width) {
		this.width = width;
    }
    public void setKorkeus(int height) {
		this.height = height;
    }
    public int getLeveys() {
		return this.width;
    }
    public int getKorkeus() {
		return this.height;
    }
    public int ala() {
		return this.width*this.height;
    }
    @Override
    public String toString() {
    	return "leveys=" + this.width + ", korkeus=" + this.height;
    }
}
