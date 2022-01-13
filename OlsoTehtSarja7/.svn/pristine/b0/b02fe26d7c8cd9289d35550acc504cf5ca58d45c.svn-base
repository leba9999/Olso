package laskin;

public class Laskin {

    private double tulos;  	// Muuttuja tulokselle

    public void nollaa() {  // Nollaa tulosmuuttuja
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }

    public void lisaa(double n) {
        tulos = tulos + n;
    }

    public void vahenna(double n) {
        tulos = tulos - n;
    }

    public void kerro(double n) {
    	tulos = tulos * n;
    }

    public void jaa(double n) {
    	if (n==0) throw new IllegalArgumentException("Nollalla ei voi jakaa");
        tulos = tulos / n;
    }

    public void nelio(int n) {
        tulos = n * n;
    }

    public void neliojuuri(double n) {
    	if (n<0) throw new IllegalArgumentException("Negatiivisella luvulla ei ole neliöjuurta");
    	tulos = Math.sqrt(n);
    }

    public void virtaON() {
        tulos = 0;
    }

    public void virtaOFF() {
        tulos = 0;
    }

}
