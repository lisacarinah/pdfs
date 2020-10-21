import javax.print.DocFlavor;
import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

public class Main {
    enum Automarken {
        VW,
        AUDI,
        BMW,
        LAMBORGHINI, // Sportmarke
        FERRARI // Sportmarke
    }

    enum Himmelsrichtungen {
        NORDEN,
        SUEDEN,
        OSTEN,
        WESTEN
    }
    enum Frauennamen  {
        SARAH,
        ANDREA,
        SANDRA,
        MICHAELA
    }
    enum Maennernamen {
        HANS,
        MAX,
        TIM,
        TOM
    }
    public static void main(String[] args) {
        // Spezieller Weg für for-Schleife
        int[] y = {2, 3, 4, 5};
        for(int x : y) {
            System.out.println(x+10);
        }
        // enums
        Automarken marke = Automarken.AUDI;
        System.out.println(marke);

        if(marke == Automarken.VW) {
            System.out.println("Marke ist VW");
        }
        else {
            System.out.println("Marke ist nicht VW");
        }

        marke = Automarken.FERRARI;
        marke = Automarken.VW;
        if(marke == Automarken.FERRARI || marke == Automarken.LAMBORGHINI) {
            System.out.println("Automarke ist ein Sportwagen.");
        }
        else {
            System.out.println("Automarke ist kein Sportwagen.");
        }
        Himmelsrichtungen richtung = Himmelsrichtungen.NORDEN;
        String name = "wuopwreu";

        // Check auf Frauenname
        String resultat = "";
        boolean resultat2 = true;
        System.out.println(Arrays.toString(Frauennamen.values()));
        for(Frauennamen wert : Frauennamen.values()) {
            if(name.equalsIgnoreCase(wert.name())) {
                resultat = name + " ist in Frauennamen enthalten.";
                resultat2 = true;
                break;
            }
            else {
                resultat = name + " ist nicht in Frauennamen enthalten.";
                resultat2 = false;
            }
        }
        System.out.println(resultat);

        // zweiter weg:
        if(resultat2 == true) {
            System.out.println(name + "  ist enhalten");
        }
        else {
            System.out.println(name + " ist nicht enhalten");
        }
        


    }
}

