package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/description/
 */
public class SummaryRanges {

    /**
     * Runtime 6 ms  Beats 44.51% of users with Java
     * Memory 41.61 MB Beats 41.01% of users with Java
     *
     * if queue.clear() change to queue = new LinkedList<>() then the result will be 84.26%
     */
    public List<String> summaryRanges(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (queue.isEmpty()) {
                queue.addLast(current);
                continue;
            }
            int top = queue.getLast();
            if (top + 1 == current) {
                queue.addLast(current);
            } else {
                if (queue.size() == 1) {
                    result.add(Integer.toString(queue.getFirst()));
                } else {
                    result.add(queue.getFirst() + "->" + queue.getLast());
                }
                queue.clear();
                queue.addLast(current);
            }
        }

        if (!queue.isEmpty()) {
            if (queue.size() == 1) {
                result.add(Integer.toString(queue.getFirst()));
            } else {
                result.add(queue.getFirst() + "->" + queue.getLast());
            }
        }

        return result;
    }

}
