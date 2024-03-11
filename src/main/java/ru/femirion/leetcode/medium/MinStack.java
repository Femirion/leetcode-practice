package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {

    Stack<Integer> values = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /**
     * Runtime 4 ms Beats 96.43% of users with Java
     * Memory 44.45 MB Beats 90.75% of users with Java
     */
    public void push(int val) {
        values.push(val);
        if (!min.isEmpty()) {
            int top = min.peek();
            if (top > val) {
                min.push(val);
            }
        } else {
            min.push(val);
        }
    }

    public void pop() {
        int topVal = values.pop();
        int topMin = min.peek();
        if (topMin == topVal) {
            min.pop();
        }
        values.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
