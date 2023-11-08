package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MinimumCostOfBuyingCandiesWithDiscountTest {

    @Test
    void shouldHandleMessage() {
        // when
        var solution = new MinimumCostOfBuyingCandiesWithDiscount();

        // then
//        assertThat(solution.minimumCost(new int[]{6,5,7,9,2,2})).isEqualTo(23);
//        assertThat(solution.minimumCost(new int[]{1})).isEqualTo(1);
        assertThat(solution.minimumCost(new int[]{5,5})).isEqualTo(10);
    }

}