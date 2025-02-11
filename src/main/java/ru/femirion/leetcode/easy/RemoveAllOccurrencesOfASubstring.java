package ru.femirion.leetcode.easy;

/**
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
 */
public class RemoveAllOccurrencesOfASubstring {

    /**
     * Runtime 4 ms Beats 49.85%
     * Memory 42.21 MB Beats 78.74%
     */
    public String removeOccurrences(String s, String part) {
        int writeIdx = 0;

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == part.charAt(part.length() - 1)) {
                if (part.length() - 1 <= writeIdx) {
                    int partIdx = 0;
                    boolean noDiff = true;
                    for (int i = writeIdx - part.length() + 1; i <= writeIdx - 1; i++) {
                        if (sb.charAt(i) != part.charAt(partIdx)) {
                            noDiff = false;
                            break;
                        }
                        partIdx++;
                    }
                    if (noDiff) {
                        writeIdx = writeIdx - part.length() + 1;
                    } else {
                        addToSb(sb, writeIdx, c);
                        writeIdx++;
                    }
                } else {
                    addToSb(sb, writeIdx, c);
                    writeIdx++;
                }
            } else {
                addToSb(sb, writeIdx, c);
                writeIdx++;
            }
        }



        return sb.substring(0, writeIdx);
    }

    private void addToSb(StringBuilder sb, int writeIdx, char c) {
        if (sb.length() <= writeIdx) {
            sb.append(c);
        } else {
            sb.setCharAt(writeIdx, c);
        }
    }
}
