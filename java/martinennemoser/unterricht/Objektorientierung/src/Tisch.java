public class Tisch {

    Korb k;
    Obst b;

    public void hinzufuegen(Korb korb) {
        k = korb;
    }

    public void holeBananeAusMain(Obst banane) {
        System.out.println(banane);
        b = banane;
    }

    public void zeigeObstImKorb() {
        k.zeigeObst();

        // syntaktisch ok, macht aber vielleicht keine Sinn
        k.holeMaterial();
    }

    public void zeigeMaterialVomKorb() {
        String korbMaterial = k.holeMaterial();
        System.out.println(korbMaterial);
    }

    public void erzeugeKorbMagisch() {
        b.zeigeMich();
        Korb magischerKorb = new Korb();
        Obst obst = new Obst("Magische Marille", "orange", 20, Obst.Geschmack.SEHR_LECKER, true);
        magischerKorb.hinzufuegen(obst);
        magischerKorb.hinzufuegen(b);
        magischerKorb.zeigeObst();
    }
}
