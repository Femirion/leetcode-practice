package ru.femirion.leetcode.easy;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
 */
public class FindWordsThatCanBeFormedByCharacters {

    /**
     * Runtime 6 ms Beats 81.02% of users with Java
     * Memory 45.25 MB Beats 31.90% of users with Java
     */
    public int countCharacters(String[] words, String chars) {
        int[] charsCount = new int[26];
        for (char c : chars.toCharArray()) {
            charsCount[(c - 'a')]++;
        }

        int result = 0;
        for (String word : words) {
            int cur;
            int[] tmp = new int[26];
            System.arraycopy(charsCount, 0, tmp, 0, 26);
            boolean needToAddLenght = true;
            for (int i = 0; i < word.length(); i++) {
                cur = word.charAt(i) - 'a';
                if (tmp[cur] <= 0) {
                    needToAddLenght = false;
                    break;
                }
                tmp[cur]--;
            }
            if (needToAddLenght) {
                result = result + word.length();
            }
        }
        return result;
    }
}
