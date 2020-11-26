package kraftfahrzeug;

public abstract class PKW extends Kraftfahrzeug {
    // Überschreibt Name von Elternklasse
    private String Name;
    public PKW(String name) {
        super(name);
        // Überschreibt den Wert von Name der Elternklasse
        super.Name = "audi";
        //super.Typencode = "124";
    }

    @Override
    public void fahren() {
        System.out.println("Ich fahre fahre auf 4 Räder und bin verhältnismäßig leicht.");
    }

    @Override
    public void fahren(int x) {

    }

    public void passagierEinsteigen() {
        System.out.println("Passgier ist eingestiegen.");
    }
}
