package sharedXY;

/**
* @author Leevi Koskinen 13.9.2021
*/

public class SharedXY {
	private int x;
	private int y;

	public SharedXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	 public synchronized void swap(Swappaaja s) {
		 int z = x;
		 x = y;
		 y = z;
		 System.out.println(s + " X: " + x + "Y: " + y);
	}
	public synchronized boolean onkoXYsama() {
		if(x != y) {
			return false;
		}
		return true;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}