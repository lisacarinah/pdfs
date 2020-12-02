public class Scalar extends Type {

    public Scalar(double value) {
        super(value);
    }


    @Override
    public Scalar add(Type b) {
        return new Scalar(this.getValue() + b.getValue());
    }

    @Override
    public Type subtract(Type b) {
        return new Scalar(this.getValue() - b.getValue());
    }

    @Override
    public Type multiply(Type b) {
        return new Scalar(this.getValue() * b.getValue());
    }

    @Override
    public Type divide(Type b) {
        return new Scalar(this.getValue() / b.getValue());
    }
}
