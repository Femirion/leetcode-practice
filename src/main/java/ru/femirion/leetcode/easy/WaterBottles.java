package ru.femirion.leetcode.easy;

/**
 * 1518. Water Bottles
 * https://leetcode.com/problems/water-bottles/description/
 */
public class WaterBottles {

    private int result;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.50 MB Beats 34.38%
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int posibleForExchange = numBottles / numExchange;
        if (posibleForExchange == 0) {
            return numBottles;
        }
        drinkAndExchance(numBottles, 0, numExchange);
        return result;
    }

    private void drinkAndExchance(int bottlesWithWater, int emptyBottles, int numExchange) {
        if (bottlesWithWater == 0) {
            return;
        }
        result = result + bottlesWithWater;
        emptyBottles = emptyBottles + bottlesWithWater;
        int exchangedBottles = emptyBottles / numExchange;
        int carriedBottles = emptyBottles % numExchange;
        drinkAndExchance(exchangedBottles, carriedBottles, numExchange);
    }
}
