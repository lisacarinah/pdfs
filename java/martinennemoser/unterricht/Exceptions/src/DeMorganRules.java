public class DeMorganRules {
    public static void main(String[] args) {
        int x = 0;
        // 1. DeMorgan sche Regel
        // !(x > y && u < z) ist das Gleiche wie (x <= y || u >= z)


        // Beispiel
        // !(x >= 0 && x <= 364)
        if ((x < 0 || x > 364)) {
            throw new IllegalArgumentException();
        }

        // 2. DeMorgan sche Regel
        // !(x > y || u < z) ist das Gleiche wie (x <= y && u >= z)


        // Beispiel
        // !(x > 30 || x < 40)
        if(x <= 30 && x >= 40) {
            throw new IllegalArgumentException();
        }
    }
}

