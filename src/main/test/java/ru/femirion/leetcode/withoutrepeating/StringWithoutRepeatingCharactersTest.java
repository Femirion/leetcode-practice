package ru.femirion.leetcode.withoutrepeating;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringWithoutRepeatingCharactersTest {
    @Test
    void shouldHandleMessage() {
        // given
        var in = "dvdf";

        // when
        var solution = new StringWithoutRepeatingCharacters();
        var result = solution.lengthOfLongestSubstring(in);

        // then
        assertThat(result).isEqualTo(3);
    }
}