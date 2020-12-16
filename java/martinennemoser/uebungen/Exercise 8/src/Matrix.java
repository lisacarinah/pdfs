import java.util.Arrays;

public class Matrix extends Type{

    public Matrix(double[][] arr) {
        super(arr);
    }

    @Override
    public Type add(Type b) {
        return null;
    }

    @Override
    public Type subtract(Type b) {
        return null;
    }

    @Override
    public Type multiply(Type b) {
        return null;
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
        String str = "";
        for(int i = 0; i < ((double[][])this.getValue()).length-1; i++) {
            str += Arrays.toString(((double[][])this.getValue())[i]);
            str += "\n";
        }
        str += Arrays.toString(((double[][])this.getValue())[((double[][])this.getValue()).length-1]);

        return str;
    }
}
