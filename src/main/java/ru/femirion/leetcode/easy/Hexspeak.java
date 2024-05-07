package ru.femirion.leetcode.easy;

import java.util.Set;

/**
 * 1271. Hexspeak
 * https://leetcode.com/problems/hexspeak/description/
 */
public class Hexspeak {

    private static final String ERROR = "ERROR";
    private static final Set<Character> CHARS = Set.of('A', 'B', 'C', 'D', 'E', 'F');

    /**
     * Runtime 2 ms Beats 87.18% of users with Java
     * Memory 41.94 MB Beats 69.23% of users with Java
     */
    public String toHexspeak(String num) {
        String str = Long.toHexString(Long.parseLong(num));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '0') {
                sb.append('O');
                continue;
            }
            if (cur == '1') {
                sb.append('I');
                continue;
            }
            cur = Character.toUpperCase(cur);
            if (CHARS.contains(cur)) {
                sb.append(cur);
                continue;
            }
            return ERROR;
        }
        return sb.toString();
    }
}
