package armstrong;

import static armstrong.Armstrong.MAX_LEVEL;

/**
 * Created by David Soroko on 29/02/2016.
 */
public class S {

    public static long apply(int level) {
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += applyTree(i, level);
        }
        return sum;
    }

    public static long applyTree(long k, long n) {
        if (k == 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        return applyTree(k, n - 1) + applyTree(k - 1, n);
    }


    public static void main(String[] args) {
        System.err.println(">>> " + S.apply(16)); //  5_311_718
        System.err.println(">>> " + S.apply(MAX_LEVEL)); //  8_217_822_496
    }
}
