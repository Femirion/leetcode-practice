package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FindResultantArrayAfterRemovingAnagramsTest {
    @Test
    void check() {
        // when
        var solution = new FindResultantArrayAfterRemovingAnagrams();

        // then
        assertThat(solution.removeAnagrams(new String[]{"az","azz"})).isEqualTo(List.of("az","azz"));
//        assertThat(solution.removeAnagrams(new String[]{"z","z","z","gsw","wsg","gsw","krptu"})).isEqualTo(List.of("abba", "cd"));
//        assertThat(solution.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"})).isEqualTo(List.of("abba", "cd"));
    }
}