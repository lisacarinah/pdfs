package kraftfahrzeug;

// Klasse LWK erweitert (erbt von) Kraftfahrzeug
public class LKW extends Kraftfahrzeug {
    public LKW(String name) {
        super(name);
        super.Typencode = "984";
    }

    protected void tuerSchliessen() {

    }

}
