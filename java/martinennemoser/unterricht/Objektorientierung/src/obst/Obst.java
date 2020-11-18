package obst;

import java.util.Objects;

public class Obst {
    public enum Geschmack {
        SEHR_LECKER,
        MAESSIG,
        GRAUSIG
    }
    // Konstruktor:
    // Ist eine Funktion (Methode), welche keine Rückgabetype hat
    // und gleich heißen muss wie die Klasse
    public Obst(String name, String farbe, float groesse, Geschmack geschmack, boolean istBio) {
        Farbe = farbe;
        Groesse = groesse;
        obstGeschmack = geschmack;
        IstBio = istBio;
        Name = name;
    }

    // Felder (Attribut der Klasse)
    public String Farbe;
    public Geschmack obstGeschmack;
    public int Qualitaet; //1-5 (1 ist sehr gut, 5 ist schlecht)
    public float Groesse; // in cm
    public boolean IstBio;
    public String Herkunftsland;
    public String Name;



    // Methoden
    public void mixen() {
        System.out.println("Landet im Mixer.");
    }

    public void essen(int zeitdauer) {
        System.out.println("Wird gegessen.");
        System.out.println("obst.Obst ist " + obstGeschmack);
        System.out.println("Habe " + zeitdauer + " Minuten für das Essen für die Frucht " + Name + " gebraucht.");

    }

    public void verkochen() {
        mixen();
        System.out.println("Wird verkocht.");
    }

    public void vergroessern(int faktor) {
        Groesse = Groesse * faktor;
        System.out.println("Neue Groesse: " + Groesse);
    }

    public void zeigeMich() {
        System.out.println(this);
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}
