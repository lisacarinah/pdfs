import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1D-Array
        int[] array = new int[5];  // Array mit 5 Elementen

        // gesamtes Array ausgeben
        System.out.println(Arrays.toString(array));

        // spezifisches Element ausgeben (z.B. das 4e):
        System.out.println(array[4]);

        // 2D String-Array mit 9x9 (81) Elementen
        String[][] strArrray = new String[9][9];

        // 3D Float-Array mit 4x4x2 (32) Elmenten
        float[][][] fltArray = new float[4][4][2];

        // String comparison

        String var1 = "auto";
        String var2 = "xylophon";
        String var3 = "banane";
        String var4 = "boot";
        String var5 = "boot   ";

        int gr = var2.compareTo(var1);
        System.out.println(gr);

        gr = var1.compareTo(var2);
        System.out.println(gr);

        gr = var1.compareTo(var3);
        System.out.println(gr);

        gr = var3.compareTo(var4);
        System.out.println(gr);

        gr = var4.compareTo(var4);
        System.out.println(gr);

        gr = var4.compareTo(var5);
        System.out.println(gr);

        if(var1.length() > var2.length()) {
           System.out.println(var1 + " hat mehr Buchstaben als " + var2);
        }



    }
}
