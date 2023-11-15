package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LongestCommonPrefixTest {
    @Test
    void check() {
        // when
        var solution = new LongestCommonPrefix();

        // then
        assertThat(solution.longestCommonPrefix(new String[]{"ab", "a"})).isEqualTo("a");
        assertThat(solution.longestCommonPrefix(new String[]{"dog","racecar","car"})).isEqualTo("");
        assertThat(solution.longestCommonPrefix(new String[]{"flower","flow","flight"})).isEqualTo("fl");
        assertThat(solution.longestCommonPrefix(new String[]{"flower","flower","flower","flower"})).isEqualTo("flower");
    }
    @Test
    void checkFastVersion() {
        // when
        var solution = new LongestCommonPrefix();

        // then
        assertThat(solution.longestCommonPrefixFast(new String[]{"ab", "a"})).isEqualTo("a");
        assertThat(solution.longestCommonPrefixFast(new String[]{"dog","racecar","car"})).isEqualTo("");
        assertThat(solution.longestCommonPrefixFast(new String[]{"flower","flow","flight"})).isEqualTo("fl");
        assertThat(solution.longestCommonPrefixFast(new String[]{"flower","flower","flower","flower"})).isEqualTo("flower");
    }
}