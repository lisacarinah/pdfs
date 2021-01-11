public class Calculator {
    public Type add(Type a, Type b) {
        System.out.print(a + " + " + b +" = ");
        Type r = a.add(b);
        System.out.println(r);
        return r;
    }

    public Type subtract(Type a, Type b) {
        System.out.print(a + " - " + b +" = ");
        Type r = a.subtract(b);
        System.out.println(r);
        return r;
    }

    public Type multiply(Type a, Type b) {
        System.out.print(a + " * " + b +" = ");
        Type r = a.multiply(b);
        System.out.println(r);
        return r;
    }

    public Type divide(Type a, Type b) {
        System.out.print(a + " / " + b +" = ");
        Type r = a.divide(b);
        System.out.println(r);
        return r;
    }
}
