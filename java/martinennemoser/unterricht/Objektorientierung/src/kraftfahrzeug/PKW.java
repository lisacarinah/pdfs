package kraftfahrzeug;

public class PKW extends Kraftfahrzeug {
    // Überschreibt Name von Elternklasse
    private String Name;
    public PKW(String name) {
        super(name);
        // Überschreibt den Wert von Name der Elternklasse
        super.Name = "audi";
        //super.Typencode = "124";
    }
}
