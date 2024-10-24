package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsFromSourceToTarget {

    /**
     * Runtime 2 ms Beats 78.55%
     * Memory 46.36 MB Beats 40.38%ph
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        curPath.add(0);
        backtracking(result, curPath, graph, 0);

        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> curPath, int[][] graph, int curNode) {
        if (curNode == graph.length - 1) {
            result.add(new ArrayList<>(curPath));
            return;
        }

        int[] nextNodes = graph[curNode];
        for (int i = 0; i < nextNodes.length; i++) {
            curPath.add(nextNodes[i]);
            backtracking(result, curPath, graph, nextNodes[i]);
            curPath.remove((Integer) curPath.size() - 1);
        }
    }
}
