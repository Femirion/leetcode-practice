package ru.femirion.leetcode.medium;

/**
 * 1409. Queries on a Permutation With Key
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/description/
 */
public class QueriesOnAPermutationWithKey {

    /**
     * Runtime 6 ms Beats 68.39% Analyze Complexity
     * Memory 42.18 MB Beats 94.83%
     */
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        int[] qr = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            qr[i] = i - 1;
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = qr[queries[i]];
            for (int j = 1; j < m + 1; j++) {
                if (qr[j] < qr[queries[i]]) {
                    qr[j]++;
                }
            }
            qr[queries[i]] = 0;

        }

        return result;
    }
}
