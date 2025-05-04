package ru.femirion.leetcode.medium;

/**
 * 670. Maximum Swap
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class MaximumSwap {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.55 MB Beats 50.49%
     */
    public int maximumSwap(int num) {
        int[] nums = new int[10];
        int idx = 9;

        while (0 < num || 0 <= idx) {
            int cur = num % 10;
            nums[idx] = cur;
            num = num / 10;
            idx--;
        }

        int i = 0;
        for (; i < 10; i++) {
            if (nums[i] != 0) {
                break;
            }
        }

        for (int j = i; j < 10; j++) {
            int max = nums[j];
            int maxIdx = -1;
            boolean wasFound = false;
            for (int x = j + 1; x < 10; x++) {
                if (max < nums[x] || (wasFound && max == nums[x])) {
                    max = nums[x];
                    maxIdx = x;
                    wasFound = true;
                }
            }
            if (maxIdx != -1) {
                int tmp = nums[j];
                nums[j] = nums[maxIdx];
                nums[maxIdx] = tmp;
                break;
            }
        }

        int result = nums[0];
        for (i = 1; i < 10; i++) {
            result = result * 10 + nums[i];
        }

        return result;
    }
}
