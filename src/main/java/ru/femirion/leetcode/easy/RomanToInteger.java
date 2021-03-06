package ru.femirion.leetcode.easy;

/**
 https://leetcode.com/problems/roman-to-integer/

 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
 which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However,
 the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer.



 Example 1:

 Input: s = "III"
 Output: 3
 Explanation: III = 3.
 Example 2:

 Input: s = "LVIII"
 Output: 58
 Explanation: L = 50, V= 5, III = 3.
 Example 3:

 Input: s = "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


 Constraints:

 1 <= s.length <= 15
 s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    /**
     * Runtime: 4 ms, faster than 93.32% of Java online submissions for Roman to Integer.
     * Memory Usage: 42.4 MB, less than 92.83% of Java online submissions for Roman to Integer.
     */
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case 'M': {
                    result = result + 1000;
                    break;
                }
                case 'D': {
                    result = result + 500;
                    break;
                }
                case 'L': {
                    result = result + 50;
                    break;
                }
                case 'V': {
                    result = result + 5;
                    break;
                }
                case 'C': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'D') {
                            result = result + 400;
                            i = i + 1;
                            break;
                        }
                        if (next == 'M') {
                            result = result + 900;
                            i = i + 1;
                            break;
                        }
                        result = result + 100;
                        break;
                    }
                    result = result + 100;
                    break;
                }
                case 'X': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'L') {
                            result = result + 40;
                            i = i + 1;
                            break;
                        }
                        if (next == 'C') {
                            result = result + 90;
                            i = i + 1;
                            break;
                        }
                        result = result + 10;
                        break;
                    }
                    result = result + 10;
                    break;
                }
                case 'I': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'V') {
                            result = result + 4;
                            i = i + 1;
                            break;
                        }
                        if (next == 'X') {
                            result = result + 9;
                            i = i + 1;
                            break;
                        }
                        result = result + 1;
                        break;
                    }
                    result = result + 1;
                    break;
                }
            }
        }

        return result;
    }
}
