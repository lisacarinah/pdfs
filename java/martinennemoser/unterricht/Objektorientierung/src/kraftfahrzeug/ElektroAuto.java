package kraftfahrzeug;

public class ElektroAuto extends PKW {

    public ElektroAuto(String name) {
        super(name);
    }

    @Override
    public void benzinTanken() {
        System.out.println("Elektorautos unterstützen diese Operation nicht.");
    }
}
