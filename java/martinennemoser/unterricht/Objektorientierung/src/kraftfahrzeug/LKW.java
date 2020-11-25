package kraftfahrzeug;

// Klasse LWK erweitert (erbt von) Kraftfahrzeug
public class LKW extends Kraftfahrzeug {
    public LKW(String name) {
        super(name, "984");
        //super.Typencode = "984";
    }

    protected void tuerSchliessen() {

    }

    @Override
    public void fahren(int x) {

    }

    @Override
    public void fahren() {
        System.out.println("Ich fahre auf 4 Räder und fahre recht schwer.");
    }

    @Override
    public int fahren(String geschwindigkeit) {
        return 10;
    }
}
