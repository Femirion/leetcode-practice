package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class NumberOfProvinces {

    private Stack<Item> stack = new Stack<>();

    /**
     * Runtime 5 ms Beats 14.03%
     * Memory 47.09 MB Beats 75.93%
     */
    public int findCircleNum(int[][] isConnected) {
        int total = 0;
        var t = stack;

        for (int i = 0; i < isConnected.length; i++) {
            passTheCity(isConnected, isConnected[i], i);
            if (!stack.isEmpty()) {
                total++;
            }
            while(!stack.isEmpty()) {
                Item item = stack.pop();
                int[] curCity = item.arr;
                int idx = item.idx;
                passTheCity(isConnected, curCity, idx);
            }
        }

        return total;
    }

    private void passTheCity(int[][] isConnected, int[] cities, int idx) {
        var t = stack;
        for (int j = 0; j < cities.length; j++) {
            if (isConnected[idx][j] == 0) {
                continue;
            }
            isConnected[idx][j] = 0;
            isConnected[j][idx] = 0;
            isConnected[j][j] = 0;
            stack.push(new Item(isConnected[j], j));
        }
    }

    private static class Item {
        private int[] arr;
        private int idx;

        public Item(int[] arr, int idx) {
            this.arr = arr;
            this.idx = idx;
        }
    }
}
