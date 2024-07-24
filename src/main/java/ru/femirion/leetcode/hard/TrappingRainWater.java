package ru.femirion.leetcode.hard;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {

    /**
     * Runtime 1 ms Beats 69.20%
     * Memory 46.51 MB Beats 13.83%
     */
    public int trap(int[] height) {
        int p = 0;
        int q = 0;
        int leftResult = 0;
        int cur = 0;
        while (q < height.length) {
            if (height[p] <= height[q]) {
                p = q;
                q++;
                if (cur != 0) {
                    leftResult = leftResult + cur;
                    cur = 0;
                }
                continue;
            }
            cur = cur + height[p] - height[q];
            q++;
        }

        p = height.length - 1;
        q = height.length - 1;
        cur = 0;
        int rigthResult = 0;
        while (0 <= q) {
            if (height[p] < height[q]) {
                p = q;
                q--;
                if (cur != 0) {
                    rigthResult = rigthResult + cur;
                    cur = 0;
                }
                continue;
            }
            cur = cur + height[p] - height[q];
            q--;
        }

        return leftResult + rigthResult;
    }
}
