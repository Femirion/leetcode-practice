package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosestElements {

    /**
     * Runtime 8 ms Beats 47.32%
     * Memory 45.60 MB Beats 79.78%
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (arr[arr.length - 1] <= x) {
            int size = arr.length;
            for (int i = size - 1; size - 1 - k < i; i--) {
                result.addFirst(arr[i]);
            }
            return result;
        }

        if (arr.length == 1) {
            result.add(arr[0]);
            return result;
        }

        int idx = Arrays.binarySearch(arr, x);
        int right = idx < 0 ? Math.abs(idx) - 1 : idx;
        int left = 0;
        if (right - 1 < 0) {
            left = right;
            right = right + 1;
        } else {
            left = right - 1;
        }


        int i = 0;
        while (i < k) {
            int leftDiff = left == -1 ? Integer.MAX_VALUE : Math.abs(arr[left] - x);
            int rightDiff = right == arr.length ? Integer.MAX_VALUE : Math.abs(arr[right] - x);
            if (rightDiff < leftDiff) {
                result.addLast(arr[right]);
                right++;

            } else {
                result.addFirst(arr[left]);
                left--;
            }
            i++;
        }

        return result;
    }

    /**
     * Runtim 16 ms Beats 32.14%
     * Memory 45.61 MB Beats 69.77%
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        ArrayList<Integer> result = new ArrayList<>();

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (arr[arr.length - 1] <= x) {
            int size = arr.length;
            for (int i = size - 1; size - 1 - k < i; i--) {
                result.add(0, arr[i]);
            }
            return result;
        }

        if (arr.length == 1) {
            result.add(arr[0]);
            return result;
        }

        int idx = Arrays.binarySearch(arr, x);
        int right = idx < 0 ? Math.abs(idx) - 1 : idx;
        int left = 0;
        if (right - 1 < 0) {
            left = right;
            right = right + 1;
        } else {
            left = right - 1;
        }


        int i = 0;
        while (i < k) {
            int leftDiff = left == -1 ? Integer.MAX_VALUE : Math.abs(arr[left] - x);
            int rightDiff = right == arr.length ? Integer.MAX_VALUE : Math.abs(arr[right] - x);
            if (rightDiff < leftDiff) {
                result.add(arr[right]);
                right++;

            } else {
                result.add(0, arr[left]);
                left--;
            }
            i++;
        }

        return result;
    }
}
