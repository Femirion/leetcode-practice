package ru.femirion.leetcode.easy;

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class NthTribonacciNumber {

    /**
     * out of time((
     */
    public int tribonacciReq(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacciReq(n) + tribonacciReq(n - 1) + tribonacciReq(n - 2);
    }

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.58MB Beats 8.30% of users with Java
     */
    public int tribonacci(int n) {
        int arr[] = new int[3 + n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
}
