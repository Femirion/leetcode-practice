package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    /**
     * Runtime 46 ms Beats 5.44%
     * Memory 45.47 MB Beats 5.20%
     */
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        result.add("()");

        for (int i = 1; i < n; i++) {
            Set<String> tmpResult = new HashSet<>();
            for (String curStr : result) {
                for (int m = 0; m < curStr.length(); m++) {
                    for (int k = m; k < curStr.length(); k++) {
                        String tmpStr = curStr.substring(0, m) + "(" + curStr.substring(m, k) + ")" + curStr.substring(k);
                        if (validate(tmpStr)) {
                            tmpResult.add(tmpStr);
                        }
                    }
                }
                result = tmpResult;
            }
        }

        return result.stream().toList();
    }

    private boolean validate(String str) {
        int counter = 0;
        char[] arr = str.toCharArray();
        for (char cur : arr) {
            if (cur == '(') {
                counter++;
                continue;
            }
            if (cur == ')') {
                counter--;
                if (counter < 0) {
                    return false;
                }
            }
        }
        return counter == 0;
    }

}
