package ru.femirion.leetcode.easy;

/**
 * 1710. Maximum Units on a Truck
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class MaximumUnitsOnATruck {

    /**
     * Runtime 3ms Beats 95.13%of users with Java
     * Memory 45.32MB Beats 7.14%of users with Java
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] items = new int[1002];
        for (int i = 0; i < boxTypes.length; i++) {
            int boxCount = boxTypes[i][0];
            int itemCount = boxTypes[i][1];
            items[itemCount] = items[itemCount] + boxCount;
        }

        int sum = 0;
        int allBoxes = 0;
        for (int i = items.length; i >= 0; i--) {
            int boxCount = items[i];
            if (allBoxes + boxCount > truckSize) {
                return sum + ((truckSize - allBoxes) * i);
            } else {
                sum = sum + (boxCount * i);
                allBoxes = allBoxes + boxCount;
            }
        }
        return sum;
    }

}
