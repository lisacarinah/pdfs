import kaffeemaschine.Kaffeemaschine;
import kraftfahrzeug.*;
import obst.Korb;
import obst.Obst;
import obst.Tisch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ####### BEISPIEL KRAFTFAHRZEUG (Vererbung) ################

        // primitive datentypen: int, float, double, long, short, byte

        // komplexe Datentypen: String, Klassen, Arrays

        // Kraftfahrzeug erstellen
        Kraftfahrzeug kraftfahrzeug = new Kraftfahrzeug("Neues Kraftfahrzeug.");
        kraftfahrzeug.fahren();

        Kraftfahrzeug kraftfahrzeug2 = new Kraftfahrzeug(10);
        kraftfahrzeug2.warten();

        ElektrischerLKW elektrischerLKW = new ElektrischerLKW();
        elektrischerLKW.fahren();

        LKW man = new LKW("man");
        man.fahren();

        PKW vw = new PKW("vw");
        vw.fahren();

        PKW bmw = new PKW("bmw");
        bmw.fahren();
        // Geht nicht, da Typencode protected
        // System.out.println("Der Typencode unseres BMWs lautet " + bmw.Typencode);

        ElektroAuto teslaModelS = new ElektroAuto();
        ArrayList<Kraftfahrzeug> fuhrPark = new ArrayList<Kraftfahrzeug>();
        fuhrPark.add(man);
        fuhrPark.add(vw);
        fuhrPark.add(teslaModelS);
        System.out.println("Nun folgt die Schleife:");
        for(int i = 0; i < fuhrPark.size(); i++) {
            // Gib Name aus
            System.out.println(fuhrPark.get(i));

            // Betanke Kraftfahrzeug
            Kraftfahrzeug fahrzeug = fuhrPark.get(i);

            if(!(fahrzeug instanceof ElektroAuto)) {
                fahrzeug.benzinTanken();
            }
        }

        ElektroAuto porsche = new ElektroAuto();
        porsche.benzinTanken();



        // ####### BEISPIEL OBST ################
        System.out.println("####### BEISPIEL OBST ################");
        // 3 Objekte (Instanzen) der Klasse Obst
        Obst banane = new Obst("Banane", "gelb", 20, Obst.Geschmack.SEHR_LECKER, true);
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

        // Ausgabe des Namens des Obsts
        System.out.println("Ich bin eine(e) " + banane.Name);
        System.out.println("Ich bin eine(e) " + banane.getName());

        System.out.println("Ich bin eine(e) " + banane);
        // wird so nie gemacht
        System.out.println("Ich bin eine(e) " + banane.toString());


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
