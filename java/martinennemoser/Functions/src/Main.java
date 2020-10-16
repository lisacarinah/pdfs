public class Main {

    public static void main(String[] andi) {
        foo();
        int y = bar();
        System.out.println(y);
        int returnWert = baz(4);
        System.out.println(returnWert);

        // Ausgabe: "Hallo Hans Mair!"
        // str1 + " " + str2
        // str1 = "Hans"
        // str2 = "Mair"
        namenVerbindung("Hans", "Mair");
        namenVerbindung("Toni", "Eder");

    }

    public static void foo() {
        System.out.println("Hallo von foo");
        int y_foo = bar();
        System.out.println(y_foo);
        return;
    }

    public static int bar() {
        int x = 10;
        return x;
        // wird nicht ausgeführt:
        // x = 30;
    }

    public static int baz(int wert) {
        int z = wert + 10;
        return z;
    }

    public static void namenVerbindung(String str1, String str2) {
        String nameZ = str1 + " " + str2 + "!";
        System.out.println(nameZ);
    }


}
