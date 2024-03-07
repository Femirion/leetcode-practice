package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/description/
 */
public class OnlineStockSpan {

    private Stack<Item> stack = new Stack<>();

    /**
     * Runtime 34 ms Beats 28.21% of users with Java
     * Memory 55.60 MB Beats 21.48% of users with Java
     */
    public int next(int price) {
        int idx = 1;
        if (stack.isEmpty()) {
            stack.push(new Item(price, idx));
            return idx;
        }

        Item top = stack.peek();

        if (price < top.val) {
            stack.push(new Item(price, idx));
            return idx;
        }

        while (!stack.isEmpty() && top.val <= price) {
            top = stack.peek();
            if (top.val <= price) {
                stack.pop();
                idx = idx + top.idx;
            }
        }

        stack.push(new Item(price, idx));
        return idx;
    }

    private static class Item {
        int val;
        int idx;

        public Item(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }
}
