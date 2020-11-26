public class Person {


    // Felder
    enum PersonStatus {
        KAUFT_TICKET,
        AUSSERHALB_DES_FLUGHAFENS,
        IST_IN_HALLE,
        KAUFT_GESCHENK,
        WARTET_AM_GATE,
        SITZT_IM_CAFE,
        RUFT_TAXI,
        IST_AM_BOARDING,
        IST_IN_DER_LUFT
    }

    private String Vorname;
    private String Nachname;
    public PersonStatus Status;

    // Konstruktor
    public Person(String vorname, String nachname) {
        Vorname = vorname;
        Nachname = nachname;
        Status = PersonStatus.AUSSERHALB_DES_FLUGHAFENS;
    }

    // Methoden

    public void betrittFlughafen() {
        if(Status == PersonStatus.AUSSERHALB_DES_FLUGHAFENS) {
            Status = PersonStatus.IST_IN_HALLE;
        } else {
            System.out.println("Person kann den Flughafen nicht betreten.");
        }
    }

    public void kauftGeschenk() {
        if(Status == PersonStatus.IST_IN_HALLE || Status == PersonStatus.SITZT_IM_CAFE) {
            Status = PersonStatus.KAUFT_GESCHENK;
        } else {
            System.out.println("Person kann momentan keine Geschenke kaufen.");
        }

//       // Äquivalent
//        if(Status != PersonStatus.AM_FLUGHAFEN) {
//            System.out.println("Person kann momentan keine Geschenke kaufen.");
//            return;
//        }
//        Status = PersonStatus.KAUFT_GESCHENK;
    }
    // kauft Geschenk (nur möglich, wenn Person am Flughafen ist)
    // wartet am Gate (nur möglich, wenn Person am Flughafen ist)
    
    // ruft Taxi (nur möglich, nachdem Person Flughafen verlassen hat)
}
