package ru.femirion.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RegularExpressionMatchingTest {

    @Test
    void isMatch() {
        var solution = new RegularExpressionMatching();


        assertThat(solution.isMatch("aaa", "aaaa")).isFalse();
//        assertThat(solution.isMatch("ab", ".*c")).isFalse();
//        assertThat(solution.isMatch("mississippi", "mis*is*p*.")).isFalse();
//        assertThat(solution.isMatch("aab", "c*a*b")).isTrue();
//        assertThat(solution.isMatch("aa", "a")).isFalse();
//        assertThat(solution.isMatch("ab", ".*")).isTrue();
//        assertThat(solution.isMatch("ab", ".*c")).isTrue();
//        assertThat(solution.isMatch("aa", "a*")).isTrue();
//        assertThat(solution.isMatch("ab", ".*c")).isFalse();
    }
}