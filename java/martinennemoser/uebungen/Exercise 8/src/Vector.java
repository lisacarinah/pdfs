import java.util.Arrays;

public class Vector extends Type {

    public Vector(double a, double b, double c) {
        super(new double[]{a, b, c});
    }

    @Override
    public Type add(Type b) {
        double[] array = (double[]) this.value;
        double[] array2 = (double[]) b.getValue();

        return new Vector(array[0] + array2[0], array[1] + array2[1], array[2] + array2[2]);
    }

    @Override
    public Type subtract(Type b) {
        double[] array = (double[]) this.value;
        double[] array2 = (double[]) b.getValue();

        return new Vector(array[0] - array2[0], array[1] - array2[1], array[2] - array2[2]);
    }

    @Override
    public Type multiply(Type b) {
        double[] array = (double[]) this.value;
        double[] array2 = (double[]) b.getValue();

        double x0 = array[0] * array2[0];
        double x1 = array[1] * array2[1];
        double x2 = array[2] * array2[2];

        double x4 = x0 + x1 + x2;

        return new Scalar(x4);
    }

    @Override
    public Type divide(Type b) {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString((double[]) value);
    }

    @Override
    public String getLength() {
        return "3";
    }
}
