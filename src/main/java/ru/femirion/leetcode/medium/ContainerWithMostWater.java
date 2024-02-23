package ru.femirion.leetcode.medium;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    /**
     * Runtime 4 ms Beats 89.31% of users with Java
     * Memory 58.06 MB Beats 37.18% of users with Java
     */
    public int maxArea(int[] height) {
        int max = 0;
        int currentArea;
        int p = 0;
        int q = height.length - 1;
        int minHeight;
        int distance;

        while (p < q) {
            minHeight = Math.min(height[p], height[q]);
            distance = q - p;
            currentArea = minHeight * distance;
            if (currentArea > max) {
                max = currentArea;
            }
            if (height[p] > height[q]) {
                q--;
            } else {
                p++;
            }
        }
        return max;
    }
}
