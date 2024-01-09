package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class CheckIfNAndItsDoubleExist {

    /**
     * Runtime 2ms Beats 81.34% of users with Java
     * Memory 43.13MB Beats 23.27% of users with Java
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int n2 = current * 2;
            if (current % 2 == 0) {
                int half = current / 2;
                if (numbers.contains(half)) {
                    return true;
                }
            }
            if (numbers.contains(n2)) {
                return true;
            } else {
                numbers.add(current);
            }
        }
        return false;
    }

    /**
     * Runtime 1ms Beats 98.10% of users with Java
     * Memory 44.12MB Beats 5.11% of users with Java
     */
    public boolean checkIfExist1(int[] arr) {
        int[] numbers = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (current == 305 || current == 610) {
                int x = 0;
            }
            if (current % 2 == 0) {
                int half = current / 2;
                if (numbers[half + 1000] != 0) {
                    return true;
                }
            }
            int n2 = current * 2;
            if (Math.abs(n2) < 1000) {
                if (numbers[n2 + 1000] != 0) {
                    return true;
                } else {
                    numbers[current + 1000] = numbers[current + 1000] + 1;
                }
            } else {
                numbers[current + 1000] = numbers[current + 1000] + 1;
            }
        }
        return false;
    }

}
