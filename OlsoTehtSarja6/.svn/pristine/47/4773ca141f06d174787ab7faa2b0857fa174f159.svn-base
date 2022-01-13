package halkohomma;

/**
* @author Leevi Koskinen 14.9.2021
*/

public class HalkohommaMain { 
	public static void main(String args[]) {
		final int halonhakkaajia = 3;
		final int partiolaisia = 3;
		
		Halkovarasto halkovarasto = new Halkovarasto();
		Halonhakkaaja[] halonhakkaajat = new Halonhakkaaja[halonhakkaajia];
		Partiolainen[] partiolaiset = new Partiolainen[partiolaisia];
		for(Halonhakkaaja h : halonhakkaajat) {
			h = new Halonhakkaaja(halkovarasto);
			h.start();
		}
		for(Partiolainen p : partiolaiset) {
			p = new Partiolainen(halkovarasto);
			p.start();
		}

	}
}