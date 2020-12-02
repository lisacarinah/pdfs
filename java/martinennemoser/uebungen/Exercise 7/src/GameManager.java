import java.util.Scanner;

public class GameManager {

    private Board board = new Board();
    private Ship[] ships = new Ship[5];

    private Ship selectedShip = null;
    private int selRow = -1;
    private int selColumn = -1;
    private int selDirection = -1;

    public void createShips() {
        ships[0] = new Boat(0, 2);
        ships[1] = new Carrier(1, 3);
        ships[2] = new Submarine(2, 4);
        ships[3] = new Cruiser(3, 5);
        ships[4] = new Destroyer(4, 6);
    }

    public void gameLoop() {
        Scanner in = new Scanner(System.in);
        while(remainingShips().length > 0) {
            board.displayGrid();
            System.out.println();
            displayRemainingShips();
            boolean correctInput = performUserInput(in);
            if(correctInput) {
                placeShips();
            }
        }
    }

    private void placeShips() {
        int start = -1;
        int length = selectedShip.getSize();

        if(selDirection == 0) { //Horizontal
            start = selColumn;
            for(int i= start; i < start + length; i++) {
                Board.playerField[selRow][i] = true;
            }
        } else { //Vertical
            for(int i = selRow; i < selRow + length; i++) {
                for(int j = 0; j < Board.COLUMNS; j++) {
                    if(j == selColumn) {
                        Board.playerField[i][j] = true;
                    }
                }
            }
        }
    }

    private boolean performUserInput(Scanner in) {
        System.out.print("\nChoose a ship: ");
        int shipCount = 5;

        int ship = in.nextInt();

        if(ship < 0 || ship > shipCount - 1) {
            System.out.println("Invalid input!\n");
            return false;
        }
        selectedShip = ships[ship];


        if(ship < 0 || ship > shipCount) {
            System.out.println("Invalid input!\n");
            return false;
        }

        System.out.print("Choose the starting position (e.g. A4): ");
        int row = in.next().charAt(0) - 65;
        int column = in.nextInt() - 1;

        if(column < 0 || column > Board.COLUMNS - 1 || row < 0 || row > Board.ROWS - 1) {
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

        int shipLength = selectedShip.getSize();
       // equivalent: int shipLength = ships[ship].getSize();
        if((direction == 0 && column + shipLength > Board.COLUMNS) ||
                (direction == 1 && row + shipLength > Board.ROWS)) {
            System.out.println("Invalid input!\n");
            return false;
        }

        selectedShip.setIsAvailable(true);

        return true;

    }

    private void displayRemainingShips() {
        System.out.println("Your remaining ships are:");
        for(int i = 0; i < this.remainingShips().length; i++) {
            //todo
            //System.out.print(i + ": " + Ships.values()[i] + "("+ Ships.values()[i].getSize() + ") ");
        }
        System.out.println();
    }

    private Ship[] remainingShips() {
        //todo
        return null;
    }
}
