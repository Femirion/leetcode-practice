package ru.femirion.leetcode.easy;

/**
 * 2269. Find the K-Beauty of a Number
 * https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 */
public class FindTheKBeautyOfANumber {

    /**
     * Runtime 2ms Beats 19.05%of users with Java
     * Memory 39.23MB Beats 74.96%of users with Java
     */
    public int divisorSubstrings(int num, int k) {
        String tmp = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (sb.length() == k) {
                sb.deleteCharAt(0);
                sb.append(tmp.charAt(i));
                int tmpInt = Integer.parseInt(sb.toString());
                if (tmpInt != 0 && num % tmpInt == 0) {
                    count++;
                }
            } else {
                sb.append(tmp.charAt(i));
                if (sb.length() == k) {
                    int tmpInt = Integer.parseInt(sb.toString());
                    if (tmpInt != 0 && num % tmpInt == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
