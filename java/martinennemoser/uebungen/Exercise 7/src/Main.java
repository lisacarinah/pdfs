import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.createShips();

        gameManager.gameLoop();

    }
}
