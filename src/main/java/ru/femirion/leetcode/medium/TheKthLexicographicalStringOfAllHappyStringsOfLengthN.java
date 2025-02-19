package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 */
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    private List<String> generatedStrings = new ArrayList<>();

    /**
     * Runtime 11 ms Beats 60.82%
     * Memory 45.05 MB Beats 39.18%
     */
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        generate(n, 0, sb, 'n');
        return generatedStrings.size() < k ? "" : generatedStrings.get(k - 1);
    }

    private void generate(int maxSize, int curSize, StringBuilder sb, char prevChar) {
        if (maxSize == curSize) {
            generatedStrings.add(sb.toString());
            return;
        }

        for (char c = 'a'; c < 'd'; c++) {
            if (c == prevChar) {
                continue;
            }
            sb.append(c);
            generate(maxSize, curSize + 1, sb, c);
            sb.deleteCharAt(curSize);
        }
    }
}
