package ru.femirion.leetcode.medium;

/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    /**
     * Runtime 5 ms Beats 75.75%
     * Memory 44.60 MB Beats 58.75%
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] fromLeftToRight = new int[n];
        int[] fromRightToLeft = new int[n];
        int prevV = boxes.charAt(0) - '0';
        int suffV = boxes.charAt(n - 1) - '0';
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                fromLeftToRight[i] = fromLeftToRight[i - 1] + prevV;
                prevV = prevV + (boxes.charAt(i) - '0');
            }
            if (n - i != n) {
                fromRightToLeft[n - i - 1] = fromRightToLeft[n - i] + suffV;
                suffV = suffV + (boxes.charAt(n - i - 1) - '0');
            }
        }

        int[] result = new int[boxes.length()];
        for (int i = 0; i < n; i++) {
            result[i] = fromLeftToRight[i] + fromRightToLeft[i];
        }

        return result;
    }
}
