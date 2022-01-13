package pokerikadet;
/**
*
* @author Leevi Koskinen 23.8.2021
*/
public class Kortti {
    final static String[] MAAT = {"Hertta", "Ruutu", "Risti", "Pata"};
    final static int HERTTA = 0, RUUTU = 1, RISTI = 2, PATA = 3;
    // Ylläolevien näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista muodossa Luokka.tunnus, esim.  Kortti.HERTTA

    // Esittele instanssimuuttujat kortin maan ja arvon tallettamiseksi
    private int maa;
    private int arvo;

    // Kirjoita kahden parametrin konstruktori
    public Kortti (int maa, int arvo){
    	this.maa = maa;
    	this.arvo = arvo;
    }
    // Kirjoita getterit
    public int getMaa() {
    	return this.maa;
    }
    public int getArvo() {
    	return this.arvo;
    }
    
    // Kirjoita toString()
    @Override
    public String toString() {
    	return this.MAAT[this.maa] + " " + this.arvo;
    }
}
