package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    /**
     * Runtime 6 ms Beats 38.54%
     * Memory 41.68 MB Beats 38.60%
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<Integer>();


        for(int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            int top = stack.peek();
            if (num - top == 1) {
                stack.push(num);
                continue;
            }
            int end = stack.pop();
            if (stack.isEmpty()) {
                result.add(Integer.toString(end));
                stack.push(num);
                continue;
            }
            int start = 0;
            while (!stack.isEmpty()) {
                start = stack.pop();
            }
            result.add(start + "->" + end);
            stack.push(num);
        }

        if (!stack.isEmpty()) {
            int top = stack.peek();
            int end = stack.pop();
            if (stack.isEmpty()) {
                result.add(Integer.toString(end));
                return result;
            }
            int start = 0;
            while (!stack.isEmpty()) {
                start = stack.pop();
            }
            result.add(start + "->" + end);
        }

        return result;
    }

    /**
     * Runtime 6 ms Beats 38.54%
     * Memory 41.78 MB Beats 24.51%
     */
    public List<String> summaryRanges3(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return new ArrayList<>();
        }

        int p = 0;
        int q = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur - prev == 1) {
                q++;
                prev = nums[i];
                continue;
            }
            if (p == q) {
                result.add(Integer.toString(nums[p]));
            } else {
                result.add(nums[p] + "->" + nums[q]);
            }
            p = i;
            q = i;
            prev = nums[i];
        }
            if (p == q) {
                result.add(Integer.toString(nums[p]));
            } else {
                result.add(nums[p] + "->" + nums[q]);
            }
        return result;
    }

    /**
     * Runtime 5 ms Beats 78.28%
     * Memory 41.68 MB Beats 38.60%
     */
    public List<String> summaryRanges4(int[] nums) {
        List<String> result = new ArrayList<>();


        int p = 0;
        while (p < nums.length) {
            int q = p + 1;
            while (q < nums.length && (nums[q] - nums[p] == q - p)) {
                q++;
            }
            if (q - p == 1) {
                result.add(Integer.toString(nums[p]));
            } else {
                result.add(nums[p] + "->" + nums[q - 1]);
            }
            p = q;
        }
        return result;
    }

}
