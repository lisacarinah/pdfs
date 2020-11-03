import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Geben Sie die Anzahl an Zeilen ein:");
        String n1 = in.nextLine();
        int num_rows = Integer.parseInt(n1);
        if (num_rows > 20) {
            System.out.println("Die 1. Eingabe war leider nicht korrekt");
        }
        System.out.println("Geben Sie die Anzahl an Spalten ein:");
        String n2 = in.nextLine();
        int num_colums = Integer.parseInt(n2);
        if (num_colums > 20) {
            System.out.println("Die 2. Eingabe war leider nicht korrekt");
        }

        // 1. Generierung des Arrays
        String[][] arr = new String[num_rows][num_colums];
        int counter = 0;
        for(int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_colums; j++) {
              if (counter % 3 == 0) {
                  arr[i][j] = "O";
              }
              else {
                  arr[i][j] = "X";
              }
              System.out.println(counter);
              System.out.println(num_colums*i + j);
              System.out.println("------------");
              counter = counter + 1;
              // Äquivalenzen:
              // counter += 1
                // counter++;
            }
        }

        // 2. Ausgabe des Arrays
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_colums; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


        // XXO
        //
    }
}