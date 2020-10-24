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

        int z = kleinereZahl(4, 5); // z == 4
        System.out.println(z);
        z = kleinereZahl(48, 53); // z == 48
        System.out.println(z);

        // return-Wert muss nicht in Variable gespeichert werden.
        // das ist optional
        kleinereZahl(7, 0);

        int result = multChain(0);
        System.out.println(result); // 1 * 2 * 3

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

    public static int kleinereZahl(int x, int y) {
        boolean result = x < y;
        if(result == true) {
            return x;
        }
        else {
            return y;
        }
    }

    // Rekursion
    public static int endlosRekursion(int count) {
        System.out.println("Aufgerufen zum " + count + "en mal.");
        int temp = ++count;
        int variable = multChain(temp);
        return count;
    }

    // Fakultät rekursiv
    public static int multChain(int count) {
        if(count == 1 || count == 0) {
            return 1;
        }

        int result = multChain(count-1);
        result = result * count;
        return result;
    }


}
