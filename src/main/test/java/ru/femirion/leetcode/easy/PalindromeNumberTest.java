package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PalindromeNumberTest {

    @Test
    void check() {
        // when
        var solution = new PalindromeNumber();

        // then
        assertThat(solution.isPalindrome(1234)).isEqualTo(false);
//        assertThat(solution.isPalindrome(1221)).isEqualTo(true);
    }
}