package kraftfahrzeug;

public class Kraftfahrzeug {
    public String Name;
    String Typencode;
    public Kraftfahrzeug(String name) {
        this.Name = name;
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
