public class Main {
    public static void main(String[] args) {
        int a = 30;
        int b = 70;
        // Example 1: Subtract two numbers
        int z = a - b;
        System.out.println("The value is: " + z);

        // Example 2: Check if number is dividable by 3
        // is number a dividable by 3 without rest
        a = 6;
        if(a%3==0) {
            System.out.println("Number is dividable");
        }
        else {
            System.out.println("Number is not dividable");
        }

        // Example 3: Number exchange
        //
        a = 6;
        b = 8;
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Exampe4 switch-case
        a = 4;
        if(a == 4) {
            System.out.println("a=4");
        }
        else if (a == 5) {
            System.out.println("a=5");
        }
        else {
            System.out.println("a is something different");
        }

        a = 0;
        switch(a) {
            case 4:
                if (a == 4) {

                }
                System.out.println("a=4");
                break;
            case 5:
                System.out.println("a=5");
                break;
            default:
                System.out.println("a is something different");
        }

        // Example 5: leap year
        // leap year is normally dividable by 4 without rest
        // years that are dividable by 100 without rest are not leap years
        // years that are dividable by 100 and 400 are leap years anyway

        int year = 1904;

        // using if/else
        if(year % 4 == 0) {
            // if year is dividable by 100 it is normally not a leap year
            if (year % 100 == 0) {
                // except it is dividable by 400
                if(year % 400 == 0) {
                    System.out.println("Is a leap year");
                }
                else {
                    System.out.println("Is not a leap year");
                }
            }
            else {
                System.out.println("Is a leap year");

            }
        }
        else {
            System.out.println("Is not a leap year");
        }

        // using switch/case
        switch(year%4) {
            case 0:
                if (year % 100 == 0) {
                    if(year % 400 == 0) {
                        System.out.println("Is a leap year");
                    }
                    else {
                        System.out.println("Is not a leap year");
                    }
                }
                else {
                    System.out.println("Is a leap year");

                }
                //break;
            default:
                System.out.println("Is not a leap year");
        }

        // Example 6: logical operators
        // Umkehrung von <: >=
        // Umkehrung von >: <=
        // Umkehrung von ==: !=
        // Umkehrung von <=: >
        // Umkehrung von >=: <

        System.out.println("Logical operators");
        int x = 5;
        int y = 4;
        z = 8;
        if(x > y && x < z) {
            System.out.println("x is between x and y.");
        }
        else {
            System.out.println("x it not between x and y");
        }

        z = 9;
        if(z > x || z > y) {
            System.out.println("z is greater x or greater y.");
            System.out.println("Expression is " + (z > x || z > y));
        }
        else {
            System.out.println("z is smaller x and smaller y.");
        }

        // Truth Table
        //  x    |   y   |  "&&"  |  "||"
        // True  | True  |  True  | True
        // False | True  |  False | True
        // True  | False |  False | True
        // False | False |  False | False

        boolean iWantAnApple = true;
        boolean iWantAPear = true;

        if(iWantAnApple && iWantAPear) {
            System.out.println("I buy an apple and a pear.");
        }
        else if(iWantAnApple && !iWantAPear) {
            System.out.println("I buy an apple but not a pear.");
        }
        else if(!iWantAnApple && iWantAPear) {
            System.out.println("I buy an pear but not an apple.");
        }
        else if(!iWantAnApple && !iWantAPear) {
            System.out.println("I dont want to buy and apple and a pear and also not one of them!.");
        }
        else if(!iWantAnApple || iWantAPear) {
            System.out.println("I dont want to have an apple or I want to" +
                    "hava a pear.");
        }
        else if(!(iWantAnApple && iWantAPear)) {
            System.out.println(("I dont want to buy both! But one of them is ok"));
        }

        // iWantAnApple | iWantAPear | !iWantAnApple && !iWantAPear | !(iWantAnApple && iWantAPear)
        //  true        |   true     |          false               |          false
        //  true        |   false    |          false               |          true
        //  false       |   true     |          false               |          true
        //  false       |   false    |          true                |          true

    }
}
