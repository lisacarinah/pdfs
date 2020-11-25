package kraftfahrzeug;

public class ElektroAuto extends PKW {
    protected int spulgroesse;
    private final int MAX_GESCHWINDIGKEIT;

    public ElektroAuto() {
        super("name");
        //super.Typencode = "932";
        spulgroesse = 10;
        MAX_GESCHWINDIGKEIT = 1000;
    }

    @Override
    public void benzinTanken() {
        System.out.println("Elektorautos unterstützen diese Operation nicht.");
    }

    @Override
    public void fahren(int beschleunigung) {
        System.out.println("Anfang von Fahren");
        if(beschleunigung < this.MAX_GESCHWINDIGKEIT) {
            beschleunigung *= 10;
            this.fahren(beschleunigung);
            System.out.println("Fertig");
        } else {
            System.out.println("Max Geschwindigkeit ereicht.");
        }
        System.out.println("Ich fahre auf 4 Räder und habe einen Elektromotor ");
    }

    protected void tuerSchliessen() {

    }
}
