package ru.femirion.leetcode.medium;

/**
 * 1701. Average Waiting Time
 * https://leetcode.com/problems/average-waiting-time/description/
 */
public class AverageWaitingTime {

    /**
     * Runtime 3 ms Beats 93.25%
     * Memory 72.81 MB Beats 42.68%
     */
    public double averageWaitingTime(int[][] customers) {
        int count = customers.length;
        double serviceTime = customers[0][0] + customers[0][1];
        double totalWait = serviceTime - customers[0][0];

        for (int i = 1; i < count; i++) {
            if (serviceTime < customers[i][0]) {
                serviceTime = customers[i][0];
            }
            serviceTime = serviceTime + customers[i][1];
            totalWait = totalWait + (serviceTime - customers[i][0]);
        }
        return totalWait / count;
    }
}
