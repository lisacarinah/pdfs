public class SimpleException {
    public static void main(String[] args) {
        int x = 4;
        int y = 0;
        try {
            double z = x / y;
        } catch(ArithmeticException e) {
            System.out.println("Division by 0 is not valid.");
        }

        double z = x / (y  +1);
    }
}
