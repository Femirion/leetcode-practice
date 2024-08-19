package ru.femirion.leetcode.medium;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/description/
 */
public class CountPrimes {

    /**
     * Runtime 169 ms Beats 12.92%
     * Memory 64.36 MB Beats 7.20%
     */
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2 ) {
            return 0;
        }

        if (n == 3) {
            return 1;
        }

        int[] primes = new int [n + 1];
        primes[0] = -1;
        primes[1] = -1;
        primes[2] = 1;
        primes[3] = 1;

        int step = 2;
        while (step <= n) {
            for (int i = step; i <= n; i = i + step) {
                if (step < i) {
                    primes[i] = -1;
                }
            }
            boolean hasFound = false;
            for (int i = step + 1; i <= n; i++) {
                if (primes[i] != - 1) {
                    step = i;
                    hasFound = true;
                    break;
                }
            }
            if (!hasFound) {
                step++;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i] != - 1) {
                count++;
            }
        }

        return count;
    }
}
