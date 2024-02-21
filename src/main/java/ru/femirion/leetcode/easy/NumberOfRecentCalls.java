package ru.femirion.leetcode.easy;

import java.util.LinkedList;

/**
 * 933. Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/description/
 */
public class NumberOfRecentCalls {

    private LinkedList<Integer> list = new LinkedList<>();

    public NumberOfRecentCalls() {
    }

    /**
     * Runtime 20 ms Beats 91.86% of users with Java
     * Memory 54.23 MB Beats 48.89% of users with Java
     */
    public int ping(int t) {
        int head;
        while(true) {
            if (list.isEmpty()) {
                break;
            }
            head = list.getFirst();
            if (t - head >= 3000) {
                list.removeFirst();
            } else {
                break;
            }
        }
        list.addLast(t);
        return list.size();
    }
}
