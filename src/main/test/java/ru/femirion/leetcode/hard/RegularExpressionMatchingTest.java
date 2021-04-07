package ru.femirion.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegularExpressionMatchingTest {

    @Test
    void forDebug() {
        var solution = new RegularExpressionMatching();

        assertThat(solution.isMatch("bbbba", ".*a*a")).isTrue();
    }

    @Test
    void isMatch() {
        var solution = new RegularExpressionMatching();

        assertThat(solution.isMatch("a", "ab*")).isTrue();
        assertThat(solution.isMatch("aaa", "ab*a")).isFalse();
        assertThat(solution.isMatch("aaa", "a*a")).isTrue();
        assertThat(solution.isMatch("mississippi", "mis*is*ip*.")).isTrue();
        assertThat(solution.isMatch("aaa", "a.a")).isTrue();
        assertThat(solution.isMatch("aaa", "aaaa")).isFalse();
        assertThat(solution.isMatch("ab", ".*c")).isFalse();
        assertThat(solution.isMatch("mississippi", "mis*is*p*.")).isFalse();
        assertThat(solution.isMatch("aab", "c*a*b")).isTrue();
        assertThat(solution.isMatch("aa", "a")).isFalse();
        assertThat(solution.isMatch("ab", ".*")).isTrue();
        assertThat(solution.isMatch("ab", ".*c")).isFalse();
        assertThat(solution.isMatch("aa", "a*")).isTrue();
        assertThat(solution.isMatch("ab", ".*c")).isFalse();
    }
}