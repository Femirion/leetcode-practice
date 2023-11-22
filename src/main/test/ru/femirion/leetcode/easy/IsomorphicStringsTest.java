package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IsomorphicStringsTest {

    @Test
    void check() {
        // when
        var solution = new IsomorphicStrings();

        // then
//        assertThat(solution.isIsomorphic("paper", "title")).isEqualTo(true);
//        assertThat(solution.isIsomorphic("bbbaaaba", "aaabbbba")).isEqualTo(false);
        assertThat(solution.isIsomorphic("badc", "baba")).isEqualTo(false);
    }

}