import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /// Guessing numbers
        // input to algorithm is guessNumber (int)
        // fixed number: for example 30
        // user inputs a number (guessNumber)
        // check if guessNumber greater, smaller or equal 30
        // if guessNumber > 30 then write to console: "Number is too large"
        // if guessNumber < 30 then write to console: "Number is too small"
        // if guessNumber == 30 then write to console: "Number guessed!" and terminate loop

        Scanner in = new Scanner(System.in);

        System.out.print("Enter number: ");
        String guessNumber_str = in.nextLine();
        int guessNumber = Integer.parseInt(guessNumber_str);

        int fixedNumber = 30;
        while(true) {
            if (guessNumber < fixedNumber) {
                System.out.println("Number is too small.");
            } else if (guessNumber > fixedNumber) {
                System.out.println("Number is too large.");
            }
            if(guessNumber == fixedNumber) {
                System.out.println("Congrats!! You guessed the number!");
                break;
            }

            System.out.print("Enter number: ");
            guessNumber_str = in.nextLine();
            guessNumber = Integer.parseInt(guessNumber_str);

        }

//            if (guessNumber == fixedNumber) {
//                System.out.println("Congrats!! You guessed the number!");
//            }



    }
}
