package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    /**
     * Runtime 1ms Beats 91.46%of users with Java
     * Memory 41.05MB Beats 52.89%of users with Java
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 2; i < numRows; i++) {
            List<Integer> listTmp = new ArrayList<>();
            for (int j = 0; j < i - 1; j++) {
                if (j == 0 || j == i - 1) {
                    listTmp.add(1);
                } else {
                    listTmp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(listTmp);
        }
        return result;
    }
}
