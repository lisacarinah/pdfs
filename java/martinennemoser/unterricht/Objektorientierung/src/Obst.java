public class Obst {
    enum Geschmack {
        SEHR_LECKER,
        MAESSIG,
        GRAUSIG
    }
    // Konstruktor:
    // Ist eine Funktion (Methode), welche keine Rückgabetype hat
    // und gleich heißen muss wie die Klasse
    public Obst(String name, String farbe, float groesse, Geschmack geschmack, boolean istBio) {
        Name = name;
        Farbe = farbe;
        Groesse = groesse;
        obstGeschmack = geschmack;
        IstBio = istBio;
    }

    // Felder (Attribut der Klasse)
    String Farbe;
    Geschmack obstGeschmack;
    int Qualitaet; //1-5 (1 ist sehr gut, 5 ist schlecht)
    float Groesse; // in cm
    boolean IstBio;
    String Herkunftsland;
    String Name;



    // Methoden
    void mixen() {
        System.out.println("Landet im Mixer.");
    }

    void essen() {
        System.out.println("Wird gegessen.");
        System.out.println("Obst ist " + obstGeschmack);

    }

    void verkochen() {
        mixen();
        System.out.println("Wird verkocht.");
    }

    void vergroessern(int faktor) {
        Groesse = Groesse * faktor;
        System.out.println("Neue Groesse: " + Groesse);
    }

    void zeigeMich() {
        System.out.println(this);
    }
}
