import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 3 Objekte (Instanzen) der Klasse Obst
        Obst banane = new Obst("banane", "gelb", 20, Obst.Geschmack.SEHR_LECKER, true);
        Obst apfel = new Obst("apfel", "rot", 10, Obst.Geschmack.GRAUSIG, false);
        Obst birne = new Obst("birne", "grün", 10, Obst.Geschmack.MAESSIG, true);

        System.out.println(banane.Farbe);
        System.out.println(apfel.Farbe);
        System.out.println(birne.Farbe);

        System.out.println(banane.Groesse);
        System.out.println(apfel.Groesse);
        System.out.println(birne.Groesse);

        System.out.println(banane.obstGeschmack);
        System.out.println(apfel.obstGeschmack);
        System.out.println(birne.obstGeschmack);

        System.out.println(banane.IstBio);
        System.out.println(apfel.IstBio);
        System.out.println(birne.IstBio);


        if(banane.obstGeschmack == Obst.Geschmack.SEHR_LECKER) {
            banane.essen();
        } else {
            banane.verkochen();
        }
        banane.vergroessern(3);
        banane.vergroessern(4);

        banane.zeigeMich();
        apfel.zeigeMich();
        birne.zeigeMich();

        // Obst zum Korb hinzufügen

        // Objekt erzeugen
        Korb korb = new Korb();
        korb.hinzufuegen(banane);
        korb.hinzufuegen(apfel);
        korb.hinzufuegen(birne);

        korb.zeigeObst();

        Tisch tisch = new Tisch();
        tisch.holeBananeAusMain(banane);
        tisch.erzeugeKorbMagisch();
    }
}
