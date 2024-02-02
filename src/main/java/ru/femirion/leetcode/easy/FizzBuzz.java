package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/description/
 */
public class FizzBuzz {

    /**
     * Runtime 2 ms Beats 26.36% of users with Java
     * Memory 45.93 MB Beats 5.19% of users with Java
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean divedBy3 = isDivedBy3(i);
            boolean divedBy5 = isDivedBy5(i);
            StringBuilder sb = new StringBuilder();
            if (divedBy3 || divedBy5) {
                if (divedBy3) {
                    sb.append("Fizz");
                }
                if (divedBy5) {
                    sb.append("Buzz");
                }
                result.add(sb.toString());
                continue;
            }
            result.add(Integer.toString(i));
        }
        return result;
    }

    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    /**
     * Runtime 1 ms Beats 99.61% of users with Java
     * Memory 44.93 MB Beats 62.28% of users with Java
     */
    public List<String> fizzBuzz1(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean divedBy3 = isDivedBy3(i);
            boolean divedBy5 = isDivedBy5(i);
            if (divedBy3 && divedBy5) {
                result.add(FIZZ_BUZZ);
                continue;
            }
            if (divedBy3) {
                result.add(FIZZ);
                continue;
            }
            if (divedBy5) {
                result.add(BUZZ);
                continue;
            }
            result.add(Integer.toString(i));
        }
        return result;
    }

    private boolean isDivedBy3(int number) {
        return number % 3 == 0;
    }

    private boolean isDivedBy5(int number) {
        return number % 5 == 0;
    }
}
