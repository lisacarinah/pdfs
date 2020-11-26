public class Passagiermaschine extends Flugzeug implements GepaeckLaden {
    @Override
    public void einladen(int menge) {
        System.out.println("Packe " + menge + " Gepäckstücke ein.");

    }

    @Override
    public void ausladen(int menge) {
        System.out.println("Packe " + menge + " Gepäckstücke aus.");
    }
}
