import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // this is a for loop
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello Codersbay");
            System.out.println("Variable i has value " + i);
            int j = i*i;
            System.out.println("Variable i multipied with itself " + j);
        }

        int j = 0;
        // this is a while loop
        while(j < 10) {
            j++; // j = j + 1;
            System.out.println("Hello Codersbay from while loop");
        }

        Random random = new Random(); // creates a new object
        int number = random.nextInt(30); // creates a new number
        System.out.println("My number is: " + number); // this is the random number

        // another while loop example
        j = 10;
        while(j != 10) { // is executed as long j is not equal to 10
            System.out.println("j is not equal to 10. j has value " + j);
            j = random.nextInt(30);
        }

        // this is a do/while loop
        // do/while always will be exectuded at least ones
        j = 10;
        do {
            System.out.println("j is not equal to 10. j has value " + j);
            j = random.nextInt(30);
        } while(j != 10);

        System.out.println("Program ends now");
    }
}

// i = 1: 1*1
// i = 2: 2*2
// i = 3: 3*3
// i = 9: 9*9