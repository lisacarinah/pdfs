public class Main {
    public static void main(String[] args) {
        //  verschieden Flughäfen
        Flughafen linz = new Flughafen();
        Person max_mustermann = new Person("Max", "Mustermann");
        System.out.println(max_mustermann.Status);
        max_mustermann.kauftGeschenk();
        linz.personBetrittFlughafenHalle(max_mustermann);
        System.out.println(max_mustermann.Status);
        max_mustermann.kauftGeschenk();
        System.out.println(max_mustermann.Status);
        max_mustermann.Status = Person.PersonStatus.IST_IN_HALLE;
        max_mustermann.Status = Person.PersonStatus.WARTET_AM_GATE;
        max_mustermann.Status = Person.PersonStatus.IST_AM_BOARDING;
        max_mustermann.Status = Person.PersonStatus.IST_IN_DER_LUFT;



        // Flughafen Linz
        // mehrere Flugzeuge mit mehreren Presonen

        // Flughafen Wien
        // mehrere Flugzeuge mit mehreren Presonen

        Kleinflugzeug cessna = new Kleinflugzeug();
        cessna.reifenAusfahren();

        Passagiermaschine boing737 = new Passagiermaschine();
        boing737.einladen(7);
        boing737.ausladen(9);
    }
}
