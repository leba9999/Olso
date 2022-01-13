import laskin.Laskin;

public class Main {

    public static void main(String[] args) {
        Laskin laskin = new Laskin();

        laskin.virtaON();
        System.out.println("...Virta p‰‰lle...");

        laskin.lisaa(500);
        System.out.println("Lis‰‰ 500    = " + laskin.annaTulos());

        laskin.lisaa(200);
        System.out.println("Lis‰‰ 200    = " + laskin.annaTulos());

        laskin.vahenna(100);
        System.out.println("V‰henn‰ 100  = " + laskin.annaTulos());

        laskin.jaa(2);
        System.out.println("Jaa 2:lla    = " + laskin.annaTulos());

        laskin.kerro(10);
        System.out.println("Kerro 10:ll‰ = " + laskin.annaTulos());

        System.out.println("...Nollaa...");
        laskin.nollaa();

        laskin.lisaa(500);
        System.out.println("Lis‰‰ 500    = " + laskin.annaTulos());

        laskin.virtaOFF();
        System.out.println("...Virta pois p‰‰lt‰...");
    }
}
