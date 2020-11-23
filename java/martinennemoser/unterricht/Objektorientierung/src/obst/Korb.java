package obst;

import java.util.ArrayList;

public class Korb {


    // Felder
    ArrayList<Obst> obstListe = new ArrayList<>();
    String material;

    // Konstruktor
    // Default Konstruktor (wird automatisch erzeugt vom Compiler)
    public Korb() {
        material = "Plastik";
    }

    // Methoden
    public void hinzufuegen(Obst obst) {
        obstListe.add(obst);
    }

    public void zeigeObst() {
        System.out.println("Zeige obst.Obst im obst.Korb:");
        for(int i = 0; i < obstListe.size(); i++) {
            System.out.println(obstListe.get(i));
        }

        // ist äquivalent zu
        System.out.println("Äquivalent:");
        for(Obst o : obstListe) {
            System.out.println(o);
        }
    }

    public String holeMaterial() {
        return material;
    }
}
