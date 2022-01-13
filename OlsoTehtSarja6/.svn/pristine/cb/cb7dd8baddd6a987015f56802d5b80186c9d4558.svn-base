package sharedXY;

/**
* @author Leevi Koskinen 13.9.2021
*/

public class Swappaaja extends Thread {
	private volatile SharedXY sharedXY;
	public Swappaaja(SharedXY sharedXY) {
		this.sharedXY = sharedXY;
	}
	public void run() {
		while(!sharedXY.onkoXYsama()) {
			// this koska haluan tulostaa swap metodissa threadin tiedot
			sharedXY.swap(this);
		}
		System.out.println("Error: X: " + sharedXY.getX() + "Y: " + sharedXY.getY());
		System.exit(0);
	}
}