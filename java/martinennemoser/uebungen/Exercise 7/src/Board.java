public class Board {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;

    private enum Row {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J
    }


    // static means:
    // a field is not bound to an instance (i.e. independent of instance)
    // and no instance is required in order to access this field
    public static boolean[][] playerField = new boolean[ROWS][COLUMNS];

    // this pointer does not exist in static method
    public static void foo() {
        //System.out.println(this.x);
    }

    public void displayGrid() {
        System.out.print("  ");
        for(int i = 1; i <= COLUMNS; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for(int i = 0; i < ROWS * 2 + 1; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if(j == 0) {
                    String rowBeginning = i % 2 == 1 ? Row.values()[i/2] + " " : "  ";
                    System.out.print(rowBeginning);
                }

                String element = i % 2 == 0 ? "--" : "|" + getCellContent(i / 2, j);
                System.out.print(element);
            }

            char endElement = i % 2 == 0 ? '-' : '|';
            System.out.println(endElement);
        }
    }

    private char getCellContent(int i, int j) {
        return playerField[i][j] == true ? 'o' : ' ';
    }
}
