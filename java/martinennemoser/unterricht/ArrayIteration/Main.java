import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // 1D-Array iteration
        float[] eindimensionalesArray = new float[9];
        for(int i = 0; i < eindimensionalesArray.length; i++) {
            eindimensionalesArray[i] = 5;
        }
        System.out.println(Arrays.toString(eindimensionalesArray));

        // 2D-Array iteration
        int[][] zweidimensionalesArray = new int[4][3];
        // Größe der 1. Dimension
        System.out.println(zweidimensionalesArray.length);

        // Größe der 2. Dimension
        System.out.println(zweidimensionalesArray[0].length);

        for(int i = 0; i < zweidimensionalesArray.length; i++) {
            for(int j = 0; j < zweidimensionalesArray[0].length; j++) {
                zweidimensionalesArray[i][j] = 15;
            }
        }
        System.out.println(Arrays.toString(zweidimensionalesArray));

        // Wert des Array in Variable speichern
        int neueVariable = zweidimensionalesArray[0][0];

        // Eine Spalte des 2D-Array in 1D Array speichern
        int[] neuesArray = zweidimensionalesArray[0];

        // Länge dieses Array
        System.out.println(neuesArray.length);
        // oder
        System.out.println(zweidimensionalesArray[0].length);

        // 3-dimensionales Array
        int[][][] dreidimensionalesArray = new int[2][2][3];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dreidimensionalesArray[i][j][k] =8;
                }
            }
        }

        // 2D Array von 3D
        int[][] neues2DArrayVon3D = dreidimensionalesArray[0];
        System.out.println(neues2DArrayVon3D);

        System.out.println(Arrays.toString(neues2DArrayVon3D));

        // 1D Array von 3D
        int[] neues1DArrayVon3D = dreidimensionalesArray[0][0];

        // Gibt Postkastenadresse aus
        System.out.println(neues1DArrayVon3D);

        // Gibt Inhalt der Postkastenaddresse aus (Zahlen)
        System.out.println(Arrays.toString(neues1DArrayVon3D));

        // Zahlenwert von 3D Array
        int zahl = dreidimensionalesArray[0][0][1];
        System.out.println(zahl);

        // äquivalent zu
        zahl = neues2DArrayVon3D[0][1];
        System.out.println(zahl);

        // äquivalent zu
        zahl = neues1DArrayVon3D[1];
        System.out.println(zahl);

    }
}