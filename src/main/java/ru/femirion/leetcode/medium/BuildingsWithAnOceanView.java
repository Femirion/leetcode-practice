package ru.femirion.leetcode.medium;

import java.util.LinkedList;

/**
 * 1762. Buildings With an Ocean View
 * https://leetcode.com/problems/buildings-with-an-ocean-view/description/
 */
public class BuildingsWithAnOceanView {

    /**
     * Runtime 3 ms Beats 76.28%
     * Memory 57.25 MB Beats 96.45%
     */
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> buildings = new LinkedList<>();

        int idx = heights.length - 1;
        int maxHeight = heights[idx];
        buildings.addFirst(idx);

        idx--;

        while (0 <= idx) {
            if (maxHeight < heights[idx]) {
                buildings.addFirst(idx);
                maxHeight = heights[idx];
            }
            idx--;
        }

        idx = 0;
        int[] result = new int[buildings.size()];
        for (Integer b : buildings) {
            result[idx] = b;
            idx++;
        }
        return result;
    }
}
