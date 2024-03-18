package ru.femirion.leetcode.easy;

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/description/
 */
public class FindTheTownJudge {

    /**
     * Runtime 2 ms Beats 99.61% of users with Java
     * Memory 53.73 MB Beats 48.44% of users with Java
     */
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] a : trust) {
            out[a[0]]++;
            in[a[1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (in[i] == n - 1 && out[i] == 0)
                return i;
        }
        return -1;
    }
}
