package ru.femirion.leetcode.easy;

/**
 * 2073. Time Needed to Buy Tickets
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 */
public class TimeNeededToBuyTickets {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.93MB Beats 30.57% of users with Java
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int number = tickets[k];
        int time = 0;
        byte afterQueue = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i > k) {
                afterQueue = 1;
            }
            time = time + Math.min(number, tickets[i] - afterQueue);
        }
        return time;
    }

}
