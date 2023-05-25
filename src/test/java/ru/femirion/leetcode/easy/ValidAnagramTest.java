package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidAnagramTest {

    @Test
    void check() {
        // when
        var solution = new ValidAnagram();

        // then
        assertThat(solution.isAnagram("anagram", "nagaram")).isEqualTo(true);
    }

}