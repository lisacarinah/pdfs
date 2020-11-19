package kraftfahrzeug;

public class Kraftfahrzeug {
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

    public void fahren() {
        System.out.println("Fahren");

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
