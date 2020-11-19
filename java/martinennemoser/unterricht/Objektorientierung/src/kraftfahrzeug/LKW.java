package kraftfahrzeug;

// Klasse LWK erweitert (erbt von) Kraftfahrzeug
public class LKW extends Kraftfahrzeug {
    public LKW(String name) {
        super(name, "984");
        //super.Typencode = "984";
    }

    protected void tuerSchliessen() {

    }

}
