package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1570. Dot Product of Two Sparse Vectors
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/
 */
public class DotProductOfTwoSparseVectors {

    public Map<Integer, Integer> map = new HashMap<>();

    /**
     * Runtime 10 ms Beats 37.42%
     * Memory 58.12 MB Beats 23.44%
     */
    DotProductOfTwoSparseVectors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        int result = 0;
        for (Integer key : this.map.keySet()) {
            result = result + (this.map.get(key) * vec.map.getOrDefault(key, 0));
        }
        return result;
    }
}
