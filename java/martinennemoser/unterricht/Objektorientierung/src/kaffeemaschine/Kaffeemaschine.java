package kaffeemaschine;

public class Kaffeemaschine {

    private final int maxKaffee; // in gramm
    private final int maxWasser = 8; // in liter
    private KAFFEEART erzeugterKaffee = null;


    private int Wasser;
    private int Kaffee;
    private boolean HatStrom;
    private boolean IstAmKaffeeMachen;

    public enum KAFFEEART {
        ESPRESSO,
        SCHWARZ,
        VERLAENGERTER,
    }

    public enum KNOPF {
        ESPRESSO,
        SCHWARZ,
        VERLAENGERTER,
        REINIGUNG
    }

    public Kaffeemaschine(int wasser, int kaffee, boolean hatStrom, boolean istAmKaffeeMachen) {
        Wasser = wasser;
        Kaffee = kaffee;
        HatStrom = hatStrom;
        IstAmKaffeeMachen = istAmKaffeeMachen;
        erzeugterKaffee = null;
        maxKaffee = 20; // Initialisierung entweder im Konstruktor oder direkt beim Feld
    }

    public void kaffeeEinfüllen(int zusaetzlicherKaffe)  {
        // maxKaffee = 30; // geht nicht weil final
        if(Kaffee + zusaetzlicherKaffe <= maxKaffee) {
            Kaffee = Kaffee + zusaetzlicherKaffe;
        } else {
            System.out.println("Kaffeetank ist voll.");
        }
    }

    public void wasserEinfüllen(int zusaetzlichesWasser) {
        if(Wasser + zusaetzlichesWasser <= maxWasser) {
            Wasser = Wasser + zusaetzlichesWasser;
        } else {
            System.out.println("Wassertank ist voll.");
        }
    }

    public void stromZustand(boolean hatStrom) {
        HatStrom = hatStrom;
    }

    // schlechter Programmierstil: Für jedes enum-Feld wird eine eigene Methode
    // erzeugt. Wartung wird sehr viel aufwändiger.
//    public void drückeEspresso() {
//        if(HatStrom == true && Wasser > 0 && Kaffee > 0) {
//            erzeugterKaffee = KAFFEEART.ESPRESSO;
//        }
//    }
//
//    public void drückeKakao() {
//        if(HatStrom == true && Wasser > 0 && Kaffee > 0) {
//            erzeugterKaffee = KAFFEEART.KAKAO;
//        }
//    }
//
//    public void drückeVerlaengerter() {
//        if(HatStrom == true && Wasser > 0 && Kaffee > 0) {
//            erzeugterKaffee = KAFFEEART.VERLAENGERTER;
//        }
//    }

    private void bohnenMahlen() {
        System.out.println("Bohnen werden gemahlen.");
    }

    public void kaffeeMachen(KNOPF knopf) {
        IstAmKaffeeMachen = true;



        if(HatStrom == true && Wasser > 0 && Kaffee > 0) {
            switch (knopf) {
                case ESPRESSO: erzeugterKaffee = KAFFEEART.ESPRESSO; break;
                case SCHWARZ: erzeugterKaffee = KAFFEEART.SCHWARZ; break;
                case VERLAENGERTER: erzeugterKaffee = KAFFEEART.VERLAENGERTER;
            }
            for(int i = 0; i < 10; i++) {
                bohnenMahlen();
                System.out.println("Kaffee in Bearbeitung.");
            }

            System.out.println("Kaffee " + erzeugterKaffee + " ist fertig.");
        } else if(HatStrom == false) {
            System.out.println("Hat keinen Strom");
        } else if(Wasser == 0) {
            System.out.println("Hat kein Wasser");
        } else if(Kaffee == 0) {
            System.out.println("Hat keinen Kaffee");
        }


        IstAmKaffeeMachen = false;

    }

    public KAFFEEART kaffeeEntnehmen() {
        if(IstAmKaffeeMachen == false && erzeugterKaffee != null) {
            return erzeugterKaffee;
        }
        System.out.println("Kaffee ist in Arbeit oder es gibt keinen Kaffee.");
        return null;
    }

}
