package ru.femirion.leetcode.easy;

/**
 * 1071. Greatest Common Divisor of Strings
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class GreatestCommonDivisorOfStrings {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.39 MB Beats 28.88% of users with Java
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str1.equals(str2)) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }

    /**
     * Runtime 8 ms Beats 10.36% of users with Java
     * Memory 42.72 MB Beats 15.08% of users with Java
     */
    public String gcdOfStrings1(String str1, String str2) {
        String tmp;
        String tmp1;
        String tmp2;

        String min = str1.length() <= str2.length() ? str1 : str2;

        for (int i = min.length(); 0 <= i; i--) {
            if (str1.length() % (i + 1) != 0 || str2.length() % (i + 1) != 0) {
                continue;
            }
            tmp = min.substring(0, i + 1);
            tmp1 = str1;
            tmp2 = str2;
            if (tmp1.replaceAll(tmp, "").length() == 0 && tmp2.replaceAll(tmp, "").length() == 0) {
                return tmp;
            }
        }
        return "";
    }

    /**
     * Runtime 1 ms Beats 74.85% of users with Java
     * Memory 41.89 MB Beats 87.90% of users with Java
     */
    public String gcdOfStrings2(String str1, String str2) {
        String tmp;
        String min = str1.length() <= str2.length() ? str1 : str2;

        for (int i = min.length(); 0 <= i; i--) {
            if (str1.length() % (i + 1) != 0 || str2.length() % (i + 1) != 0) {
                continue;
            }
            tmp = min.substring(0, i + 1);
            String tmp1 = concat(tmp, str1.length() / i);
            String tmp2 = concat(tmp, str2.length() / i);
            if (tmp1.equals(str1) && tmp2.equals(str2)) {
                return tmp;
            }
        }
        return "";
    }

    private String concat(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}
