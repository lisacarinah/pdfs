import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] zuSortierend = {5, 18, 42, 7, 0, 3, 1};

//        System.out.println(Arrays.toString(zuSortierend));
//
//        int temp1 = zuSortierend[4];
//        zuSortierend[4] = zuSortierend[0];
//        zuSortierend[0] = temp1;
//
//        System.out.println(Arrays.toString(zuSortierend));

        int aktuellKleinsterWert;
        for(int i = 0; i < zuSortierend.length; i++) {
            //int element = z[i];
            aktuellKleinsterWert = zuSortierend[i];
            int aktuellKleinsterIndex = i;
            for(int j = 0; j < zuSortierend.length; j++) {
                 int aktuellerWert = zuSortierend[j];
                 if(aktuellerWert < aktuellKleinsterWert) {
                     aktuellKleinsterWert = aktuellerWert;
                     aktuellKleinsterIndex = j;
                 }
            }

            // vertauschen-Operation
            int temp = zuSortierend[aktuellKleinsterIndex];
            zuSortierend[aktuellKleinsterIndex] = zuSortierend[i];
            zuSortierend[i] = temp;
        }

        System.out.println(Arrays.toString(zuSortierend));
    }
}
