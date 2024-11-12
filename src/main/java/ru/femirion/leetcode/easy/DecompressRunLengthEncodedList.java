package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1313. Decompress Run-Length Encoded List
 * https://leetcode.com/problems/decompress-run-length-encoded-list/description/
 */
public class DecompressRunLengthEncodedList {

    /**
     * Runtime 1 ms Beats 94.29%
     * Memory 44.44 MB Beats 91.59%
     */
    public int[] decompressRLElist2(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            size = size + nums[i];
        }

        int[] result = new int[size];
        int resultIdx = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            int count = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < count; j++) {
                result[resultIdx] = value;
                resultIdx++;
            }
        }

        return result;
    }

    /**
     * Runtime 7 ms Beats 17.46%
     * Memory 45.48 MB Beats 21.98%
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i = i + 2) {
            int count = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < count; j++) {
                resultList.add(value);
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
