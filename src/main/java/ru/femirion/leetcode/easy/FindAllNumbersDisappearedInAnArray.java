package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class FindAllNumbersDisappearedInAnArray {

    /**
     * Runtime 19 ms Beats 17.61% of users with Java
     * Memory 55.24 MB Beats 19.52% of users with Java
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            set.remove(current);
        }
        return new ArrayList<>(set);
    }

    /**
     * Runtime 19 ms Beats 17.61% of users with Java
     * Memory 55.25 MB Beats 19.52% of users with Java
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
