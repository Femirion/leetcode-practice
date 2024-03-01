package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures {

    /**
     * Runtime 63 ms Beats 59.52% of users with Java
     * Memory 56.22 MB Beats 97.06% of users with Java
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Item> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            Item cur = new Item(temperatures[i], i);
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            Item top = stack.peek();
            if (top.temp < cur.temp) {
                while (top.temp < cur.temp) {
                    result[top.idx] = cur.idx - top.idx;
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        top = stack.peek();
                    }
                }
                stack.push(cur);
            } else {
                stack.push(cur);
            }
        }

        return result;
    }

    private static class Item {
        int temp;
        int idx;

        public Item(int temp, int idx) {
            this.temp = temp;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "temp=" + temp +
                    ", idx=" + idx +
                    '}';
        }
    }
}
