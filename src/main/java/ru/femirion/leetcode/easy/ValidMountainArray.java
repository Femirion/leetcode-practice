package ru.femirion.leetcode.easy;

/**
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/description/
 */
public class ValidMountainArray {

    /**
     * Runtime 1 ms Beats 100.00% of users with Java
     * Memory 45.22 MB Beats 40.69% of users with Java
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length == 1 || arr.length == 2) {
            return false;
        }
        int prev = arr[0];
        int current;
        int i = 1;
        boolean hasLeftSide = false;
        boolean hasRightSide = false;
        for (; i < arr.length; i++) {
            current = arr[i];
            if (prev > current) {
                prev = current;
                break;
            } else {
                if (prev == current) {
                    return false;
                }
                hasLeftSide = true;
            }
            prev = current;
        }

        for (; i < arr.length; i++) {
            current = arr[i];
            if (prev < current) {
                break;
            } else {
                if (prev == current) {
                    return false;
                }
                hasRightSide = true;
            }
            prev = current;
        }

        return i == arr.length && hasLeftSide && hasRightSide;
    }
}
