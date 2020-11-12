import kaffeemaschine.Kaffeemaschine;
import obst.Korb;
import obst.Obst;
import obst.Tisch;

public class Main {

    public static void main(String[] args) {

        // ####### BEISPIEL OBST ################
        System.out.println("####### BEISPIEL OBST ################");
        // 3 Objekte (Instanzen) der Klasse Obst
        Obst banane = new Obst("obst1", "gelb", 20, Obst.Geschmack.SEHR_LECKER, true);
        Obst apfel = new Obst( "Apfel", "rot", 10, Obst.Geschmack.GRAUSIG, false);
        Obst birne = new Obst( "Birne", "grün", 10, Obst.Geschmack.MAESSIG, true);

        banane.essen(1);

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
            banane.essen(2);
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
        tisch.hinzufuegen(korb);
        tisch.holeBananeAusMain(banane);
        tisch.erzeugeKorbMagisch();

        // ####### BEISPIEL KAFFEEMASCHINE ################
        System.out.println("####### BEISPIEL KAFFEEMASCHINE ################");
        // Beispiel wie man auf KNOEPFE zugreift
        Kaffeemaschine.KNOPF x = Kaffeemaschine.KNOPF.ESPRESSO;

        Kaffeemaschine kaffeemaschine = new Kaffeemaschine(0, 0, false,false);
        kaffeemaschine.kaffeeEinfüllen(3);
        kaffeemaschine.wasserEinfüllen(2);
        kaffeemaschine.stromZustand(true);
        kaffeemaschine.kaffeeMachen(Kaffeemaschine.KNOPF.SCHWARZ);
        kaffeemaschine.kaffeeEntnehmen();
    }
}
