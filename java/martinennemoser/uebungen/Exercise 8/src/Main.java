public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scalar a = new Scalar(5);
        Scalar b = new Scalar(9);
        System.out.println("Scalar a's length+" + a.getLength());
        calculator.add(a, b);
        calculator.subtract(a, b);
        calculator.multiply(a, b);
        calculator.divide(a, b);

        Vector x = new Vector(1, 2, 3);
        Vector y = new Vector(4, 5, 6);
        System.out.println("Vector x length+" + x.getLength());
        calculator.add(x, y);
        calculator.subtract(x, y);
        calculator.multiply(x, y);

        double[] u = new double[] {3, 5, 7, 9, 1, 4};
        VectorDynamic xv = new VectorDynamic(new double[] {3, 5, 7, 9 ,1, 8});
        VectorDynamic yv = new VectorDynamic(new double[]{6, 3, 8, 3, 2, 7});
        calculator.add(xv, yv);
        System.out.println("VectorDynamic xv's length: " + xv.getLength());

    }
}
