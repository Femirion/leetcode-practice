package ru.femirion.leetcode.easy;

/**
 * 1791. Find Center of Star Graph
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 */
public class FindCenterOfStarGraph {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 67.04 MB Beats 42.50%
     */
    public int findCenter(int[][] edges) {
        int first = edges[0][0];
        int second = edges[0][1];

        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }

        if (edges[0][1] == edges[1][0]) {
            return edges[1][0];
        }

        if (edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        if (edges[0][1] == edges[1][1]) {
            return edges[1][1];
        }
        return -1;
    }
}
