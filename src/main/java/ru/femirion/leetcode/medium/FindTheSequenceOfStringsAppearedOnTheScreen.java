package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3324. Find the Sequence of Strings Appeared on the Screen
 * https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
 */
public class FindTheSequenceOfStringsAppearedOnTheScreen {

    /**
     * Runtime 7 ms Beats 66.59%
     * Memory 55.68 MB Beats 62.67%
     */
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();

        char[] chars = new char[target.length()];
        Arrays.fill(chars, '1');

        int curIdx = 0;
        StringBuilder sb = new StringBuilder();
        while (curIdx < target.length()) {
            char curChar = target.charAt(curIdx);

            if (chars[curIdx] == '1') {
                chars[curIdx] = 'a';
                sb.append('a');
                result.add(sb.toString());
            } else {
                if (curChar != chars[curIdx]) {
                    char tmp = (char) (((int) chars[curIdx]) + 1);
                    chars[curIdx] = tmp;
                    sb.setCharAt(curIdx, tmp);
                    result.add(sb.toString());
                } else {
                    curIdx++;
                }
            }
        }

        return result;
    }
}
