package ru.femirion.leetcode.easy;

/**
 * 1603. Design Parking System
 * https://leetcode.com/problems/design-parking-system/description/
 */
public class DesignParkingSystem {

    private final int[] capacity =  new int[4];

    /**
     * Runtime 7 ms Beats 100.00%
     * Memory 44.94 MB Beats 86.56%
     */
    public DesignParkingSystem(int big, int medium, int small) {
        capacity[1] = big;
        capacity[2] = medium;
        capacity[3] = small;
    }

    public boolean addCar(int carType) {
        if (0 < capacity[carType]) {
            capacity[carType]--;
            return true;
        } else {
            return false;
        }
    }
}
