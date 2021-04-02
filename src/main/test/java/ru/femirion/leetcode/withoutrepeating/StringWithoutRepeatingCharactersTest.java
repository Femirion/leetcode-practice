package ru.femirion.leetcode.withoutrepeating;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringWithoutRepeatingCharactersTest {
    @Test
    void shouldHandleMessage() {
        // when
        var solution = new StringWithoutRepeatingCharacters();

        // then
        assertThat(solution.lengthOfLongestSubstringFastVersion("abba")).isEqualTo(2);
        assertThat(solution.lengthOfLongestSubstringFastVersion("bbbbb")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstringFastVersion("abcabcbb")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstringFastVersion("bbtablud")).isEqualTo(6);
    }
}