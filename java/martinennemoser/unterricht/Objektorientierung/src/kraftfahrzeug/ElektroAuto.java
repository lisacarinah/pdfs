package kraftfahrzeug;

public class ElektroAuto extends PKW {
    protected int Spulgroesse;

    public ElektroAuto() {
        super("name");
        //super.Typencode = "932";
        Spulgroesse = 10;
    }

    @Override
    public void benzinTanken() {
        System.out.println("Elektorautos unterstützen diese Operation nicht.");
    }

    protected void tuerSchliessen() {

    }
}
