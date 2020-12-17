import java.util.Arrays;

public class Matrix extends Type {

    public Matrix(double[][] arr) {
        super(arr);
    }

    @Override
    public Type add(Type b) {
        // size of A == size of B == size of result matrix
        double[][] array = (double[][]) this.value;
        double[][] array1 = (double[][]) b.getValue();

        double[][] result = new double[array.length][array[0].length];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j] + array1[i][j];
            }
        }
        return new Matrix(result);

    }

    @Override
    public Type subtract(Type b) {
        // size of A == size of B == size of result matrix
        double[][] array = (double[][]) this.value;
        double[][] array1 = (double[][]) b.getValue();

        double[][] result = new double[array.length][array[0].length];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j] - array1[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Type multiply(Type b) {
        double[][] array = (double[][]) this.value;
        double[][] array1 = (double[][]) b.getValue();

        // array = A = 3x3 => array.length = 3, array[0].length == 3
        // array1 = B = 3x2 => array1.length = 3, array1[0].length = 2


        if(array[0].length != array1.length) {
            return null;
        }

        double[][] result = new double[array.length][array1[0].length];

        // we know: array[0].length == array[1].length
        for(int k = 0; k < array1[0].length; k++) { // loops over columns of B
            for (int j = 0; j < array.length; j++) { // loops over rows of A
                for (int i = 0; i < array[0].length; i++) {
                 //   System.out.println("Multiply " + array[j][i] + " * " + array1[i][k]);
                    result[j][k] += array[j][i]*array1[i][k];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public Type divide(Type b) {
        return null;
    }

    @Override
    public String getLength() {
        return null;
    }

    @Override
    public String toString() {
        String str = "\n";
        for(int i = 0; i < ((double[][])this.getValue()).length-1; i++) {
            str += Arrays.toString(((double[][])this.getValue())[i]);
            str += "\n";
        }
        str += Arrays.toString(((double[][])this.getValue())[((double[][])this.getValue()).length-1]);

        return str;
    }

    public double determinant() {
        return 0;
    }
}
