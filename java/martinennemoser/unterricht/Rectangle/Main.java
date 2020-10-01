import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of cols: ");
        String n1 = in.nextLine();
        int spalten = Integer.parseInt(n1);

        System.out.print("Enter number of rows: ");
        String n2 = in.nextLine();
        int zeilen = Integer.parseInt(n2);

        if (spalten <= 1 || spalten >= 20 || zeilen <= 1 || zeilen >= 20) {
            System.out.println("Rows/columns out of range");
            return;
        }

        System.out.println("Einfachste (und beste) Lösung:");
        for(int i = 1; i <= zeilen*spalten; i++) {
            if(i%3 == 0) {
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
            if(i % spalten == 0) {
                System.out.println();
            }

        }

        System.out.println("######################");
        System.out.println("Mittelschwierige (ziemliche hässliche) Lösung:");
        for(int i = 1; i <= spalten * zeilen; i++) {
            // wenn wahr, dann ist das die letze Spalte
            if(i%spalten == 0) {
                if((i+3) % 3 == 0) {
                    System.out.println("O");
                } else {
                    System.out.println("X");
                }
            } // sonst alle Elemente links von der letzten Spalte
            else {
                if((i+3) % 3 == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
        }

        System.out.println("######################");
        System.out.println("Schwierigste Lösung:");

        for(int i = 0; i < zeilen; i++) {
            for(int j = 0; j < spalten; j++) {
                if((spalten*i + (j+1)) % 3 != 0) {
                    System.out.print("X");
                }
                else {
                    System.out.print("O");
                }
            }
            System.out.println("");
        }



    }
}
