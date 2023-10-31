package ru.femirion.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegularExpressionMatchingTest {

    @Test
    void forDebug() {
        var solution = new RegularExpressionMatching();


        assertThat(solution.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*")).isTrue();
    }

    @Test
    void isMatch() {
        var solution = new RegularExpressionMatching();

        assertThat(solution.isMatch("ab", ".*..c*")).isTrue();
        assertThat(solution.isMatch("ab", ".*..")).isTrue();
        assertThat(solution.isMatch("abcd", "a.*b.*c.*d")).isTrue();
        assertThat(solution.isMatch("a", ".*.")).isTrue();
        assertThat(solution.isMatch("", ".")).isFalse();
        assertThat(solution.isMatch("a", ".*..")).isFalse();
        assertThat(solution.isMatch("a", ".*..a*")).isFalse();
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
        assertThat(solution.isMatch("ab", "ab")).isTrue();
        assertThat(solution.isMatch("bbbba", ".*a*a")).isTrue();
    }
}