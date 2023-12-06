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
        assertThat(solution.removeAnagrams1(new String[]{"az","azz"})).isEqualTo(List.of("az","azz"));
        assertThat(solution.removeAnagrams(new String[]{"z","z","z","gsw","wsg","gsw","krptu"})).isEqualTo(List.of("abba", "cd"));
        assertThat(solution.removeAnagrams1(new String[]{"abba","baba","bbaa","cd","cd"})).isEqualTo(List.of("abba", "cd"));
        assertThat(solution.removeAnagrams1(new String[]{"a","b","c","d","e"})).isEqualTo(List.of("a","b","c","d","e"));
    }
}