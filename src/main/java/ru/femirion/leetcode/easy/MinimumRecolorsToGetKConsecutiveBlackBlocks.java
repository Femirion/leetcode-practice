package ru.femirion.leetcode.easy;

/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    /**
     * Runtime 1 ms Beats 92.10%
     * Memory 41.52 MB Beats 58.45%
     */
    public int minimumRecolors(String blocks, int k) {
        int idx = 0;
        int total = Integer.MAX_VALUE;
        int operationCount = 0;
        for (; idx < k; idx++) {
            char cur = blocks.charAt(idx);
            if (cur == 'W') {
                operationCount++;
            }
        }

        if (operationCount == 0) {
            return 0;
        }

        total = operationCount;

        for (; idx < blocks.length(); idx++) {
            char first = blocks.charAt(idx - k);
            char cur = blocks.charAt(idx);
            if (first == cur) {
                continue;
            }

            if (first == 'W') {
                operationCount--;
                total = Math.min(operationCount, total);
            } else {
                operationCount++;
            }
        }

        return total;
    }
}
