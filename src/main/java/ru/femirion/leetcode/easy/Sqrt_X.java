package ru.femirion.leetcode.easy;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/description/
 */
public class Sqrt_X {

    /**
     * Runtime 1 ms Beats 87.46% of users with Java
     * Memory 41.48 MB Beats 5.66% of users with Java
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        long start = 0;
        long max = (1024 * 64);
        long end = max;
        long current;
        long sqrt1;
        long sqrt2;


        while (start <= end) {
            current = start + ((end - start) / 2);

            if (max < current) {
                end = current - 1;
                continue;
            }

            sqrt1 = current * current;
            sqrt2 = (current + 1) * (current + 1);

            if (sqrt1 == x) {
                return (int) current;
            }

            if (sqrt2 == x) {
                return (int)  current + 1;
            }

            if (sqrt1 < x && sqrt2 < 0) {
                end = current - 1;
                continue;
            }

            if (sqrt1 < x && x < sqrt2) {
                return (int)  current;
            }

            if (sqrt1 < x && sqrt2 < x) {
                start = current + 1;
            } else {
                end = current - 1;
            }

        }
        return -1;
    }
}
