package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.NestedInteger;

import java.util.List;

/**
 * 339. Nested List Weight Sum
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 */
public class NestedListWeightSum {

    private int result = 0;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.24 MB Beats 25.89%
     */
    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            passTheList(nested, 1);
        }
        return result;
    }

    private void passTheList(NestedInteger nestedList, int depth) {
        if (nestedList.isInteger()) {
            result = result + depth * nestedList.getInteger();
            return;
        }
        List<NestedInteger> nestedLists = nestedList.getList();
        for (NestedInteger nested : nestedLists) {
            passTheList(nested, depth + 1);
        }
    }
}
