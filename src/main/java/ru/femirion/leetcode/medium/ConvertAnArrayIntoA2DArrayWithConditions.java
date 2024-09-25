package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2610. Convert an Array Into a 2D Array With Conditions
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Set<Integer>> existedNums = new ArrayList<>();

    /**
     * Runtime 3 ms Beats 74.87%
     * Memory 44.97 MB Beats 41.11%
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int rowIdx = 0;
            int num = nums[i];
            Set<Integer> curExistedNums = getSet(rowIdx);
            if (curExistedNums.contains(num)) {
                while(curExistedNums.contains(num)) {
                    rowIdx++;
                    curExistedNums = getSet(rowIdx);
                }
            }

            List<Integer> curRow = getList(rowIdx);
            curRow.add(num);

            curExistedNums = getSet(rowIdx);
            curExistedNums.add(num);
        }

        return result;
    }

    private List<Integer> getList(int rowIdx) {
        List<Integer> list;
        if (rowIdx < result.size()) {
            list = result.get(rowIdx);
        } else {
            list = new ArrayList<>();
            result.add(list);
        }
        return list;
    }

    private Set<Integer> getSet(int rowIdx) {
        Set<Integer> set;
        if (rowIdx < existedNums.size()) {
            set = existedNums.get(rowIdx);
        } else {
            set = new HashSet<>();
            existedNums.add(set);
        }
        return set;
    }
}
