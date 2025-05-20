package ru.femirion.leetcode.easy;

/**
 * 3024. Type of Triangle
 * https://leetcode.com/problems/type-of-triangle/description/
 */
public class TypeOfTriangle {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.07 MB Beats 61.22%
     */
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2]
                || nums[0] + nums[2] <= nums[1]
                || nums[1] + nums[2] <= nums[0]) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        if (nums[0] == nums[1] || nums[0]  == nums[2] || nums[1]  == nums[2]) {
            return "isosceles";
        }

        return "scalene";
    }
}
