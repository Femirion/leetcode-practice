package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 * https://leetcode.com/problems/find-common-characters/description/
 */
public class FindCommonCharacters {

    /**
     * Runtime 2 ms Beats 90.56% of users with Java
     * Memory 42.87 MB Beats 76.68% of users with Java
     */
    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];

        for (char c : words[0].toCharArray()) {
            arr[c - 'a']++;
        }

        for (String word : words) {
            int[] tmp = new int[26];
            for (char c : word.toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < arr[i]) {
                    arr[i] = tmp[i];
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            while (0 < val) {
                String str = Character.toString((char) (i + 'a'));
                result.add(str);
                val--;
            }
        }

        return result;
    }
}
