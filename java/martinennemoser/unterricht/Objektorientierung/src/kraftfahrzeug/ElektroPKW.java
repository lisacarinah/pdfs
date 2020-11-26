package kraftfahrzeug;

public class ElektroPKW extends PKW implements Elektro {
    protected int spulgroesse;
    private final int MAX_GESCHWINDIGKEIT;

    public ElektroPKW(String name) {
        super(name);
        //super.Typencode = "932";
        spulgroesse = 10;
        MAX_GESCHWINDIGKEIT = 1000;
    }

    @Override
    public void fahren(int beschleunigung) {
        System.out.println("Anfang von Fahren");
        if(beschleunigung < this.MAX_GESCHWINDIGKEIT) {
            beschleunigung += 10;
            this.fahren(beschleunigung);
            System.out.println("Fertig");
        } else {
            System.out.println("Max Geschwindigkeit ereicht.");
        }
        System.out.println("Ich fahre auf 4 Räder und habe einen Elektromotor ");
    }

    protected void tuerSchliessen() {

    }

    @Override
    public void stromLaden(int kwh) {
        System.out.println("Auto wird geladen.");
    }
}
