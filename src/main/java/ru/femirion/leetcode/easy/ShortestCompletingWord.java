package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 748. Shortest Completing Word
 * https://leetcode.com/problems/shortest-completing-word/
 */
public class ShortestCompletingWord {

    /**
     * Runtime 5ms Beats 68.41% of users with Java
     * Memory 44.16MB Beats 32.34% of users with Java
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateArray = new int[26];
        String shortestWord = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for (int i = 0; i < licensePlate.length(); i++) {
            char current = licensePlate.charAt(i);
            if ((current >= '0' && current <= '9') || current == ' ') {
                continue;
            }
            int tmp = Character.toLowerCase(current) - 'a';
            licensePlateArray[tmp] = licensePlateArray[tmp] + 1;
        }

        int[] tmp = new int[26];
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(tmp, 0);
            for (int j = 0; j < words[i].length(); j++) {
                char current = words[i].charAt(i);
                int tmpChar = Character.toLowerCase(current) - 'a';
                tmp[tmpChar] = tmp[tmpChar] + 1;
            }
            boolean hasDifference = false;
            for (int j = 0; j < 26; j++) {
                if (licensePlateArray[j] != 0 && licensePlateArray[j] != tmp[j]) {
                    hasDifference = true;
                    break;
                }
            }
            if (!hasDifference) {
                if (shortestWord.length() > words[i].length()) {
                    shortestWord = words[i];
                }
            }
        }
        return shortestWord;
    }

}
