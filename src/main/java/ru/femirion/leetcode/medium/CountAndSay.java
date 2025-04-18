package ru.femirion.leetcode.medium;

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/description/
 */
public class CountAndSay {

    /**
     * Runtime 6 ms Beats 49.76%
     * Memory 41.51 MB Beats 53.17%
     */
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            char prev = sb.charAt(0);
            int count = 1;
            for (int j = 1; j < sb.length(); j++) {
                char cur = sb.charAt(j);
                if (cur == prev) {
                    count++;
                    continue;
                }

                tmp.append(count);
                tmp.append(prev);
                prev = cur;
                count = 1;
            }
            tmp.append(count);
            tmp.append(prev);
            count = 1;
            sb = tmp;
        }

        return sb.toString();
    }
}
