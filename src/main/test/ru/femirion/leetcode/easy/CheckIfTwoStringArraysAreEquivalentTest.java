package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CheckIfTwoStringArraysAreEquivalentTest {
    @Test
    void arrayStringsAreEqual() {
        // when
        var solution = new CheckIfTwoStringArraysAreEquivalent();

        // then
        String[] word1 = {"abc","d","defg"};
        String[] word2 = {"abcddef"};
        assertThat(solution.arrayStringsAreEqual(word1, word2)).isEqualTo(false);
    }

}