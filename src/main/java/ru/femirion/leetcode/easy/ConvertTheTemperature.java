package ru.femirion.leetcode.easy;

/**
 * 2469. Convert the Temperature
 * https://leetcode.com/problems/convert-the-temperature/
 */
public class ConvertTheTemperature {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.84MB Beats 27.53% of users with Java
     */
    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];

        result[0] = Double.sum(celsius, 273.15d);
        result[1] = Double.sum((celsius * 1.80d), 32.00d);
        return result;
    }
}
