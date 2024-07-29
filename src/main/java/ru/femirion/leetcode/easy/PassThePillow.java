package ru.femirion.leetcode.easy;

/**
 * 2582. Pass the Pillow
 * https://leetcode.com/problems/pass-the-pillow/description/
 */
public class PassThePillow {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.54 MB Beats 18.02%
     */
    public int passThePillow(int n, int time) {
        int totalToEndCount = time / (n - 1);
        if (totalToEndCount == 0) {
            return time + 1;
        }

        int tmp = time - (n - 1) * totalToEndCount;
        if (totalToEndCount % 2 == 0) {
            return tmp + 1;
        } else {
            return n - tmp;
        }
    }
}
