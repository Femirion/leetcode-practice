package ru.femirion.leetcode.medium;

/**
 * 1381. Design a Stack With Increment Operation
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
 */
public class DesignAStackWithIncrementOperation {


    private int[] arr;
    private int top = 0;

    /**
     * Runtime 5 ms Beats 93.47%
     * Memory 45.07 MB Beats 96.16%
     */
    public DesignAStackWithIncrementOperation(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (top == arr.length) {
            return;
        }

        arr[top] = x;
        top++;
    }

    public int pop() {
        if (top == 0) {
            return - 1;
        }

        top--;
        int val = arr[top];
        return val;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            arr[i] = arr[i] + val;
        }
    }
}
