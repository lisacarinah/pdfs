import java.util.Arrays;

public class VectorDynamic extends Type {
    public VectorDynamic(double[] val) {
        super(val);
    }

    protected boolean hasSameLength(double[] a, double[] b) {
        if(a.length == b.length) {
            return true;
        } else {
            return false;
        }

        // noch besser:
        // return a.length == b.length;
    }

    @Override
    public Type add(Type b) {
        double[] arr0 = (double[]) this.getValue();
        double[] arr1 = (double[]) b.getValue();

        if(!hasSameLength(arr0, arr1)) {
            return null;
        }

        double[] result = new double[arr1.length];

        for(int i = 0; i < arr0.length; i++)  {
            result[i] = arr0[i] + arr1[i];
        }

        return new VectorDynamic(result);
    }

    @Override
    public Type subtract(Type b) {
        double[] arr0 = (double[]) this.getValue();
        double[] arr1 = (double[]) b.getValue();

        if(!hasSameLength(arr0, arr1)) {
            return null;
        }

        double[] result = new double[arr1.length];

        for(int i = 0; i < arr0.length; i++)  {
            result[i] = arr0[i] - arr1[i];
        }

        return new VectorDynamic(result);

    }


    // v0 = (1, 2, 3)
    // v1 = (4, 5 ,6)

    // kommutativ? v0*v1 = v1*v0 => giltet

    // s = v0 * v1
    // 1*4 + 2*5 + 3*6 = 32

    // FALSCHE LÖSUNG
    // 1 + 2 + 3
    // 4 + 5 + 6
    // (1 + 2 + 3) * (4 + 5 + 6) = 6 * 15 = 75
    // = 1*4 + 1*5 + 1*6 + 2*4 + 2*5 + 2*6 + 3*4 + 3*5 + 3*6 = 75

    // Kommutativgesetz
    // Assozativgesetz
    // Distributivgesetz

    // Kommutativgesetz von Addition: a+b = b+a => giltet
    // Kommutativgesetz von Subtraktion: a-b = b-a => giltet nicht
    // Kommutativgesetz von Multiplikation: a*b = b*a => giltet
    // Kommutativgesetz von Divisionh: a/b = b/a => giltet nicht

    // Assozativgesetz von Addition: (a+b)+c = a+(b+c) => giltet
    // Assozativgesetz von Subtraktion: (a-b)-c = a-(b-c) == a-(b-c) = (a-b)+c => giltet nicht
    // Assozativgesetz von Multiplikation: (a*b)*c = a*(b*c) => giltet
    // Assozativgesetz von Divison: (a/b)/c = a/(b/c) => giltet nicht

    // Distributivgesetz von Addition: a+(b*c*d) = (a+b) * (a+c) * (a+d) => giltet nicht
    // Distributivgesetz von Subtraktion: a-(b*c*d) = (a-b) * (a-c) * (a-d) => giltet nicht
    // Distributivgesetz Multiplikation: a*(b+c+d) = (a*b) + (a*c) + (a*d) => giltet
    // Distributivgesetz Division: a/(b+c+d) = (a/b) + (a/c) + (a/d) => giltet nicht



    @Override
    public Type multiply(Type b) {
        double[] arr0 = (double[]) this.getValue();
        double[] arr1 = (double[]) b.getValue();

        if(!hasSameLength(arr0, arr1)) {
            return null;
        }

        double sum2 = 0;

        for(int i = 0; i < arr0.length; i++)  {
            double sum1 = arr0[i] * arr1[i];
            sum2 = sum1 + sum2;
        }
        return new Scalar(sum2);
    }

    @Override
    public Type divide(Type b) {
        return null;
    }

    @Override
    public String getLength() {
        double[] x = (double[]) this.getValue();
        return String.valueOf(x.length);
        // alternativ: return Integer.toString(x.length);
    }

    @Override
    public String toString() {
        return Arrays.toString((double[]) this.getValue());
    }
}
