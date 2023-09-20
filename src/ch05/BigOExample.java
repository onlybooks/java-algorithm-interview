package ch05;

public class BigOExample {
    public int O_1(int n) {
        return 42;
    }

    public int O_logn(int n) {
        while (n > 1)
            n /= 2;
        return n;
    }

    public int O_n(int n) {
        int r = 0;
        for (int i = 0; i < n; i++)
            r++;
        return r;
    }

    public int O_nlogn(int n) {
        int r = n;
        for (int i = 0; i < n; i++) {
            while (n > 1)
                n /= 2;
            n = r;
        }
        return r;
    }

    public int O_n2(int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                r += j;
        }
        return r;
    }

    public int O_2n(int n) {
        if (n <= 1)
            return n;
        else
            return O_2n(n - 1) + O_2n(n - 2);
    }

    public int O_nfact(int n) {
        for (int i = 0; i < n; i++) {
            O_nfact(n - 1);
        }
        return n;
    }

    static int count = 0;

    static public int factorial(int n) {
        if (n >= 1) {
            count++;
            return n * factorial(n - 1);
        } else {
            count++;
            return 1;
        }
    }

    public static void main(String[] args) {
        count = 0;
        factorial(5);
        System.out.printf("factorial(5), count = %d\n", count);
        count = 0;
        factorial(6);
        System.out.printf("factorial(6), count = %d\n", count);
        count = 0;
        factorial(7);
        System.out.printf("factorial(7), count = %d\n", count);
    }
}
