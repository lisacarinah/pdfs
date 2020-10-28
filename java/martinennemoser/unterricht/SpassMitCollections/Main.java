import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        beispieleArrayList();

        // intermezzo
        // Array Elemente kopieren
        int[] arrayAlt = {5, 18, 23, 435};
        int[] neuesArray = arrayVergrößern(arrayAlt, 67);
        System.out.println(Arrays.toString(neuesArray)); // [5, 18, 23, 67]


        int[] array2 = {6, 7, 87, 2, 7};
        int[] neuesArray2 = arrayVergroessern2(arrayAlt, array2);
        System.out.println(Arrays.toString(neuesArray2)); // [5, 18, 23, 6, 7, 87]

        //int element = groesstesElement(arrayAlt, array2);
        //System.out.println(element);

        beispieleLinkedList();
        beispieleSet();

    }

    public static void beispieleArrayList() {
        /////////////// List collection ////////////////
        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(10);
        liste.add(8);
        liste.add(11);
        System.out.println(liste);
        liste.add(12);
        System.out.println(liste);
        System.out.println("Länge der Liste: " + liste.size());
        liste.remove(2);
        System.out.println(liste);
        System.out.println("Länge der Liste: " + liste.size());

        // Zahlenfolge: 1 3 5 7 9 11 13 15
        ArrayList<Integer> liste1 = new ArrayList<Integer>();
        for(int i = 0; i < 15; i+=2) {
            liste1.add(i+1);
        }
        System.out.println(liste1);

        // Ein Listelement lesen
        System.out.println("Element and der Position 5 lesen:");
        int x = liste1.get(5);
        System.out.println(x);

        // Ein Listenelement überschreiben
        System.out.println("Element and der Position 7 schreiben:");
        liste1.set(7, 45);
        System.out.println(liste1.get(7));

        // Listenelemente löschen
        liste1.remove(3);
        System.out.println(liste1);

        // Listenelemente löschen
        System.out.println("Element 11 löschen:");
        liste1.remove(new Integer(11));
        // alternativ (zu bevorzugen): liste1.remove(Integer.valueOf(11));
        System.out.println(liste1);

        // Listenelement an Position einfügen
        System.out.println("Element 56 and Position 2 einfügen:");
        liste1.add(2, 56);
        System.out.println(liste1);

        // 2 Liste zusammenfügen
        liste.addAll(liste1);
        System.out.println(liste);

        // Teilliste löschen
        liste.removeAll(liste1);
        System.out.println(liste);

        // Liste sortieren
        Collections.sort(liste);
        System.out.println(liste);

        // Subliste
        System.out.println("Subliste:");
        List<Integer> subliste = liste1.subList(0, 2);
        System.out.println(subliste);

        // Liste in Array konvertieren
        Object[] arr = liste.toArray();
        System.out.println(Arrays.toString(arr));

        // Liste löschen
        liste.clear();
        System.out.println(liste);

        // Mehrere Elemente gleichzeitig einfügen
        List<Integer> neueListe = List.of(3, 5, 9, 11);
        System.out.println(neueListe);


        // "affe", "banane", "tisch", "stuhl", "monitor", "block"
        // "affe", "banane", "tisch", "glas", "stuhl", "monitor", "block"
        // "affe", "banane", "tisch", "glas", "stuhl", "block"
        // liste1: "affe", "banane", "tisch"
        // liste2: "glas", "stuhl", "block"

        System.out.println("Wörter einfügen");
        String[] arr1 = {"affe", "banane", "tisch", "stuhl", "monitor", "block"};

        ArrayList<String> stringListe = new ArrayList<>(9);
        Collections.addAll(stringListe, arr1);

        stringListe.add(3, "glas");
        stringListe.remove(5);
        //andere Möglichkeit: stringListe.remove(new String("monitor"));
        List<String> stringListe1 = stringListe.subList(0, 3); // startindex = 0, endindex = 3 - 1
        List<String> stringListe2 = stringListe.subList(3, 6);
        System.out.println(stringListe1);
        System.out.println(stringListe2);

        // Nichtveränderbare (immutable) Liste (egal welcher Datentype)
        List<Float> floatListe = List.of(3.4f, 5.3f, 4.5f);
        // geht nicht: floatListe.set(1, 6.4f);
        // geht nicht: floatListe.add(3.3f);

        System.out.println("#### Arraylist abgeschlossen ####");
    }

    public static void beispieleLinkedList() {
        System.out.println("#### Beispiele LinkedList ####");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(1, 10);
        System.out.println(list);

        // Erstes Element
        System.out.println("Erstes Element:");
        System.out.println(list.getFirst());

        // Letztes Element
        System.out.println("Letztes Element:");
        System.out.println(list.getLast());

        // Gibt es den Wert 9 in der LinkedList?
        boolean result = list.contains(9);
        System.out.println(result);
    }

    public static void beispieleSet() {
        System.out.println("#### Beispiele Set ####");
        HashSet<Integer> hashSet = new HashSet<>();

        // Element einfügen
        hashSet.add(5);
        hashSet.add(45);
        System.out.println(hashSet);

        // Gleiches Element nochmals einfügen
        hashSet.add(5);

        // Gibt es die Zahl 45 in dem Hashset
        // contains ist sehr schnell, weil suchen in HashSets sehr schnell ist
        boolean result = hashSet.contains(45);
        System.out.println(result);
    }

    public static int[] arrayVergrößern(int[] arrayAlt, int zahl){
        System.out.println(Arrays.toString(arrayAlt));
        System.out.println(zahl);

        int[] neuesArray = new int[arrayAlt.length+1];
        for(int i = 0; i < arrayAlt.length; i++) {
            neuesArray[i] = arrayAlt[i];
        }
        System.out.println(Arrays.toString(neuesArray));

        boolean istDasGleiche = (neuesArray.length - 1 == arrayAlt.length);
        System.out.println(istDasGleiche);

        neuesArray[neuesArray.length - 1] = zahl;
        //alternativ: neuesArray[arrayAlt.length] = zahl;

        return neuesArray;
    }

    public static int[] arrayVergroessern2(int[] array, int[]array2) {
        int[] neuesArray2 = new int[(array.length + array2.length)];
        for(int i = 0; i < array.length; i++)    {
            neuesArray2[i] = array[i];
        }
        for(int j = 0; j < array2.length;j++) {
            neuesArray2[array.length + j] = array2[j];
        }
        return neuesArray2;
    }

}
