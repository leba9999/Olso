package readerwriter;

/**
* @author Leevi Koskinen 14.9.2021
*/

// IntSailio on luokka, johon rakennetaan monitori
// määrittelelmällä joukko synkronoituja metodeja

public class IntSailio {
	private int arvo;

	public IntSailio() {
		arvo = 0;
	}

	public synchronized int getInt() throws InterruptedException {
	  	while (arvo == 0){
	   		wait();
	   	}
	   	int paluuarvo = arvo;
	  	if(arvo < 0) {
		   	paluuarvo = 0;
	  	} else {
		   	arvo = 0;
	  	}

	   	notifyAll();
	   	return paluuarvo;
	}

	public synchronized void setInt(int n) throws InterruptedException {
	   	while (!(arvo == 0)){
	   		wait();
	   	}
		
	   	arvo = n;
	   	notifyAll();
	 }
}




