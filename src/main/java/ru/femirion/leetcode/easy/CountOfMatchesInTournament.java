package ru.femirion.leetcode.easy;

/**
 * 1688. Count of Matches in Tournament
 * https://leetcode.com/problems/count-of-matches-in-tournament/
 */
public class CountOfMatchesInTournament {
    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 39.50MB Beats 19.75% of users with Java
     */
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            int nextRound = n / 2;
            count = count + nextRound;
            if (n % 2 != 0) {
                n = nextRound + 1;
            } else {
                n = nextRound;
            }
        }
        return count;
    }
}
