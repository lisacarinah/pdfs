public class Main {
    public static void main(String[] args) {
        // Example 1: write a for loop with i = 0..29
        // if i is dividable by 5 with 0 rest: System.out.println(i)
        // if i is not dividable by 5 with 0 rest: System.out.println("Not dividable")
        for(int i = 0; i < 30; i++) {
            if(i % 5 == 0) {
                System.out.println(i);
            }
            else {
                System.out.println(i + " not dividable");
            }
        }

        // Example 2: write a loop with two variables: i and j
        // k is incremented by 1
        // l is incremented by 1
        // System.out.println("k: " + k)
        // System.out.println("l: " + l)
        // loop runs until k+l < 60
        int k = 0, l = 0;
        while(k+l < 60) {
            System.out.println("k: " + k);
            System.out.println("l: " + l);
            System.out.println("l+k" + (k+l));
            k++;
            l++;
        }

        // Example 3: break
        for(int u = 0; u < 10; u++) {
            System.out.println("Value of u: " + u);
            if (u == 3) {
                break; // exit loop early
            }
        }

        System.out.println("Continue example");
        // Example 4: continue
        for(int u = 0; u < 10; u++) {
            if(u == 3) {
                continue;
            }

            System.out.println("Value of u: " + u);
        }

        System.out.println("Try break");
        // Example 5: Concrete example where continue is useful
        for(int u = 0; u < 10; u++) {
            if(u == 0) {
                continue;
            }
            float result = 20.f / u;
            System.out.println(result);
        }

        // Example 6: for loop u = 0....40
        // if u == 10: Sys...("u = 10")
        // if u == 15: continue
        // if u == 30: break
        // print u (Sys...("u="+u))

        for(int u = 0; u<= 40; u++) {
            if(u == 10) {
                System.out.println("u=10");
            }
            if (u == 15) {
                continue;
            }
            if (u == 30) {
                break;
            }
            System.out.println("u=" + u);
        }

        // Example 6: Fibonacci Numbers
        // a, b
        // 0, 1 = 0+1 = 1
        // 1, 1 = 1+1 = 2
        // 1, 2 = 1+2 = 3
        // 2, 3 = 2+3 = 5
        // 3, 5 = 3+5 = 8
        // 5, 8 = 5+8 = 13
        // 8, 13 = 8+13 = 21
        // 13, 21 = 13+21 = 34

        // variable n0 = 200: Upper bound (Obergrenze) for calculated fibonacci numbers
        // a = 0
        // b = 1
        // n0 = a + b
        // calculate fibonacci number and print (System.out.println) result

        int a = 0;
        int b = 1;
        int n0 = 0;

        while(n0 < 200) {
            System.out.println("Fibonacci number " + n0);
            n0 = a + b;
            a = b;
            b = n0;
        }



    }
}
