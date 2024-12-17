package ru.femirion.leetcode.medium;

/**
 * 2182. Construct String With Repeat Limit
 * https://leetcode.com/problems/construct-string-with-repeat-limit/description/
 */
public class ConstructStringWithRepeatLimit {

    /**
     * Runtime 188 ms Beats 9.75%
     * Memory 45.50 MB Beats 76.67%
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 25;
        while (0 <= idx) {
            if (chars[idx] == 0) {
                idx--;
                continue;
            }

            // если элементов меньше чем repeatLimit
            // тогда добавляем все и переходим к след
            if (chars[idx] <= repeatLimit) {
                for (int i = 0; i < chars[idx]; i++) {
                    sb.append((char) ('a' + idx));
                }
                chars[idx] = 0;
                idx--;
                continue;
            }

            // если элементов больше чем repeatLimit
            // тогда добавляем repeatLimit и переходим к след,
            // чтобы разбить строку следующим символом, и вернуться
            for (int i = 0; i < repeatLimit; i++) {
                sb.append((char) ('a' + idx));
            }
            boolean wasAdded = false;
            chars[idx] = chars[idx] - repeatLimit;
            int nextIdx = idx - 1;
            while (0 <= nextIdx) {
                if (chars[nextIdx] <= 0) {
                    nextIdx--;
                    continue;
                }
                wasAdded = true;
                chars[nextIdx] = chars[nextIdx] - 1;
                sb.append((char) ('a' + nextIdx));
                break;
            }

            if (!wasAdded) {
                break;
            }

        }

        return sb.toString();
    }
}
