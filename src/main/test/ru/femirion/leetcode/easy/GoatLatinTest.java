package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GoatLatinTest {
    @Test
    void check() {
        // when
        var solution = new GoatLatin();

        // then
//        assertThat(solution.toGoatLatin("I speak Goat Latin")).isEqualTo("Imaa peaksmaaa oatGmaaaa atinLmaaaaa");
        assertThat(solution.toGoatLatin("HZ sg L")).isEqualTo("ZHmaa gsmaaa Lmaaaa");
    }
}