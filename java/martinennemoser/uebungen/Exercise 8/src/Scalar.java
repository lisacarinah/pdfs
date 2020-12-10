public class Scalar extends Type {

    public Scalar(double value) {
        super(value);
    }


    @Override
    public Type add(Type b) {
        return new Scalar((double) this.getValue() + (double) b.getValue());
    }

    @Override
    public Type subtract(Type b) {
        return new Scalar((double) this.getValue() - (double) b.getValue());
    }

    @Override
    public Type multiply(Type b) {
        return new Scalar((double) this.getValue() * (double) b.getValue());
    }

    @Override
    public Type divide(Type b) {
        return new Scalar((double) this.getValue() / (double) b.getValue());
    }
}
