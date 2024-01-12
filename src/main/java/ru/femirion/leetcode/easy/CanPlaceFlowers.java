package ru.femirion.leetcode.easy;

/**
 * 605. Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/description/
 */
public class CanPlaceFlowers {

    /**
     * Runtime 1 ms Beats 98.41% of users with Java
     * Memory 45.99 MB Beats 5.86% of users with Java
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }

        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }

        int count = 0;
        int tmp = 0;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }

        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            count++;
            flowerbed[flowerbed.length - 1] = 1;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            int current = flowerbed[i];
            if (current == 0) {
                if (tmp == 2) {
                    tmp = 0;
                    i = i - 1;
                    count++;
                } else {
                    tmp++;
                }
            } else {
                tmp = 0;
            }
        }
        return count >= n;
    }
}
