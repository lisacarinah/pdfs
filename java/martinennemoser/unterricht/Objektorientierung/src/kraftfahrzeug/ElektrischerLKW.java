package kraftfahrzeug;

// Multiple inheritance (Mehrfachvererbung) gibt es in Java nicht
public class ElektrischerLKW extends LKW {
    protected int Spulgroesse;
    public ElektrischerLKW() {
        super("sdopöfjs");
        super.tuerSchliessen();
        Spulgroesse = 30;
    }
}
