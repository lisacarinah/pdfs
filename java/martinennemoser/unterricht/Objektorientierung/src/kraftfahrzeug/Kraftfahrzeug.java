package kraftfahrzeug;

// extends Object kann auch weggelassen werden (weil alle Klassen implizit von Object erben)
public abstract class Kraftfahrzeug extends Object {
    public String Name;
    private String Typencode;

    public Kraftfahrzeug(String name) {
        this.Name = name;
        this.Typencode = "000";
    }

    // Überladener Konstruktor
    public Kraftfahrzeug(String name, String typencode) {
        this.Name = name;
        this.Typencode = typencode;
    }

    public Kraftfahrzeug(float x) {

    }

    public Kraftfahrzeug(int y) {

    }

    @Override
    public String toString() {
        return this.Name;
    }

    // Abstrakte Methode:
    // 1. Methode hat keine Implementierung
    // 2. Alle Klassen, die von Kraftfahrzeug ableiten, müssen fahren implementieren
    public abstract void fahren(int beschleunigung);

    public abstract void fahren();

    // überladene Methode
    public int fahren(String geschwindigkeit) {
        System.out.println("Ich fahre " + geschwindigkeit);
        return 0;
    }

    public void benzinTanken()  {
        System.out.println("Tanke Benzin");

    }

    public void putzen() {
        System.out.println("Fahren");
    }

    public void warten() {
        System.out.println("Bringe Auto in die Werkstätte...");
        System.out.println("Der Typencode lautet " + Typencode);
    }
}
