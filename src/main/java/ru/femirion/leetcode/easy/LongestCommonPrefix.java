package ru.femirion.leetcode.easy;

/*
    https://leetcode.com/problems/longest-common-prefix/

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".



    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.


    Constraints:

    0 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.

* */
public class LongestCommonPrefix {

    /*
    * Runtime: 1 ms, faster than 57.25% of Java online submissions for Longest Common Prefix.
      Memory Usage: 37.5 MB, less than 34.04% of Java online submissions for Longest Common Prefix.
    * */
    public String longestCommonPrefix(String[] strs) {
        char currentChar = 0;
        boolean different = false;
        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        for (short i = 0; i < 128; i++) {
            for (String str : strs) {
                if (str.length() <= i) {
                    return result.toString();
                }

                char current = str.charAt(i);
                if (currentChar != 0) {
                    if (currentChar != current) {
                        different = true;
                    }
                } else {
                    currentChar = current;
                }
            }
            if (!different) {
                result.append(currentChar);
                currentChar = 0;
            }
        }

        return result.toString();
    }

    /*
    * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
    * Memory Usage: 36.9 MB, less than 86.51% of Java online submissions for Longest Common Prefix.
    * */
    public String longestCommonPrefixFast(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String currentPrefix = strs[0];
        for (String str : strs) {
            if (str.equals(currentPrefix)) {
                continue;
            }
            int substringSize = str.length();
            for (int i = 0; i < str.length(); i++) {
                if (currentPrefix.length() <= i) {
                    break;
                }
                char c1 = str.charAt(i);
                char c2 = currentPrefix.charAt(i);

                if (c2 != c1) {
                    substringSize = i;
                    break;
                }
            }
            if (currentPrefix.length() > substringSize) {
                currentPrefix = currentPrefix.substring(0, substringSize);
            }
        }

        return currentPrefix;
    }

}
