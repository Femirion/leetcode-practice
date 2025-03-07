package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2523. Closest Prime Numbers in Range
 * https://leetcode.com/problems/closest-prime-numbers-in-range/description/
 */
public class ClosestPrimeNumbersInRange {

    /**
     * Runtime 102 ms Beats 48.80%
     * Memory 50.84 MB Beats 22.80%
     */
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        int[] tmp = {-1, -1};
        for (int i = 0; i < primes.size(); i++) {
            if (tmp[0] == -1) {
                tmp[0] = primes.get(i);
                continue;
            }
            if (tmp[1] == -1) {
                tmp[1] = primes.get(i);
                int diff = tmp[1] - tmp[0];
                if (diff < minDiff) {
                    minDiff = diff;
                    result[0] = tmp[0];
                    result[1] = tmp[1];
                }
                tmp[0] = tmp[1];
                tmp[1] = -1;
            }
        }
        if (result[1] == -1) {
            result[0] = -1;
        }
        return result;
    }
}
