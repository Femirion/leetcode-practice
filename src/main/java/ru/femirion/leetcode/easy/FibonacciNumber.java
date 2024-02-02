package ru.femirion.leetcode.easy;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/description/
 */
public class FibonacciNumber {
    /**
     * Runtime 10 ms Beats 12.30% of users with Java
     * Memory 40.41 MB Beats 26.01% of users with Java
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.29 MB Beats 44.66% of users with Java
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
