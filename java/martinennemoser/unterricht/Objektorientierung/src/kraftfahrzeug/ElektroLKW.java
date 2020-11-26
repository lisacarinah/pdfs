package kraftfahrzeug;

public class ElektroLKW extends LKW implements Elektro {

    public ElektroLKW() {
        super("MAN");
    }

    @Override
    public void stromLaden(int kwh) {
        System.out.println("Lade LKW auf mit Strom.");
    }
}
