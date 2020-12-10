public class VectorDynamic extends Type {
    public VectorDynamic(double[] val) {
        super(val);
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
        double[] x = (double[]) this.value;
        return String.valueOf(x.length);
        // alternativ: return Integer.toString(x.length);
    }
}
