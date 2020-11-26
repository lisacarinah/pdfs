package kraftfahrzeug;

public interface Elektro {
    public abstract void stromLaden(int kwh);

    // Default Implementierung einer Methode
    default public void kapazitaetMessen() {
        for(int i = 0; i< 10000;  i++) {

        }
    }
}
