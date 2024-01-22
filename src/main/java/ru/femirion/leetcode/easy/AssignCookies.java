package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {

    /**
     * Runtime 11 ms Beats 45.97% of users with Java
     * Memory 45.16 MB Beats 54.04% of users with Java
     */
    public int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);

        int count = 0;
        int greedIdx = 0;
        int sizeIdx = 0;
        while (greedIdx <= greed.length - 1 && sizeIdx <= size.length - 1) {
            int currentGreed = greed[greedIdx];
            int currentSize = size[sizeIdx];
            if (currentSize >= currentGreed) {
                count++;
                greedIdx++;
            } else {
                greed[greedIdx] = currentGreed - currentSize;
            }
            sizeIdx++;
        }
        return count;
    }
}
