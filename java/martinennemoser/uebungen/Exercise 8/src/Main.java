public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scalar a = new Scalar(5);
        Scalar b = new Scalar(9);
        calculator.add(a, b);
        calculator.subtract(a, b);
        calculator.multiply(a, b);
        calculator.divide(a, b);
    }
}
