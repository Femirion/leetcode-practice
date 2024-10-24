package ru.femirion.leetcode.easy;

/**
 * 1678. Goal Parser Interpretation
 * https://leetcode.com/problems/goal-parser-interpretation/description/
 */
public class GoalParserInterpretation {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.29 MB Beats 89.20%
     */
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++) {
            char cur = command.charAt(i);
            if ('G' == cur) {
                sb.append(cur);
                continue;
            }
            if (command.charAt(i + 1) == 'a') {
                sb.append("al");
                i = i + 3;
            } else {
                sb.append("o");
                i = i + 1;
            }
        }
        return sb.toString();
    }
}
