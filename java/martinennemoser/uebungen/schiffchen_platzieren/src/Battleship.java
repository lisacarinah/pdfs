import java.util.Arrays;
import java.util.Scanner;

public class Battleship {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;

    private static boolean[][] playerField = new boolean[ROWS][COLUMNS];
    private static boolean[] remainingShips = new boolean[Ships.values().length];

    private static Ships selectedShip = null;
    private static int selRow = -1;
    private static int selColumn = -1;
    private static int selDirection = -1;

    private static int shipsLeft = Ships.values().length;

    public static void main(String[] args) {
        Arrays.fill(remainingShips, Boolean.TRUE);
        Scanner in = new Scanner(System.in);
        while(shipsLeft > 0) {
            displayGrid();
            System.out.println();
            displayRemainingShips();
            boolean correctInput = performUserInput(in);
            if(correctInput) {
                placeShips();
            }
        }

        displayGrid();
        in.close();
    }

    private static void displayGrid() {
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

    private static void displayRemainingShips() {
        System.out.println("Your remaining ships are:");
        for(int i = 0; i < remainingShips.length; i++) {
            if(remainingShips[i]) {
                System.out.print(i + ": " + Ships.values()[i] + "("+ Ships.values()[i].getSize() + ") ");
            }
        }
        System.out.println();
    }

    private static boolean performUserInput(Scanner in) {
        System.out.print("\nChoose a ship: ");

        int ship = in.nextInt();

        if(ship < 0 || ship > Ships.values().length - 1) {
            System.out.println("Invalid input!\n");
            return false;
        }
        selectedShip = Ships.values()[ship];


        if(ship < 0 || ship > Ships.values().length) {
            System.out.println("Invalid input!\n");
            return false;
        }

        System.out.print("Choose the starting position (e.g. A4): ");
        int row = in.next().charAt(0) - 65;
        int column = in.nextInt() - 1;

        if(column < 0 || column > COLUMNS - 1 || row < 0 || row > ROWS - 1) {
            System.out.println("Invalid input!\n");
            return false;
        }

        System.out.print("Choose direction (0 = Horizontal, 1 = Vertical): ");
        int direction = in.nextInt();
        System.out.println();

        if(direction < 0 || direction > 1) {
            System.out.println("Invalid input!\n");
            return false;
        }

        selRow = row;
        selColumn = column;
        selDirection = direction;

        int shipLength = Ships.values()[ship].getSize();
        if((direction == 0 && column + shipLength > COLUMNS) ||
                (direction == 1 && row + shipLength > ROWS)) {
            System.out.println("Invalid input!\n");
            return false;
        }

        shipsLeft--;
        remainingShips[ship] = false;

        return true;
    }

    private static void placeShips() {
        int start = -1;
        int length = selectedShip.getSize();

        if(selDirection == 0) { //Horizontal
            start = selColumn;
            for(int i= start; i < start + length; i++) {
                playerField[selRow][i] = true;
            }
        } else { //Vertical
            for(int i = selRow; i < selRow + length; i++) {
                for(int j = 0; j < COLUMNS; j++) {
                    if(j == selColumn) {
                        playerField[i][j] = true;
                    }
                }
            }
        }
    }

    private static char getCellContent(int i, int j) {
        return playerField[i][j] == true ? 'o' : ' ';
    }
}

enum Ships {
    BOAT(0, 2),
    CARRIER(1, 3),
    SUBMARINE(2, 4),
    CRUISER(3, 5),
    DESTROYER(4, 6);

    private final int id;
    private final int size;

    Ships(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getValue() { return id; }
    public int getSize() { return size; }
}

enum Row {
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