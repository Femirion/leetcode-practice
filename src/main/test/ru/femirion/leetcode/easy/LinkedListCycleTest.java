package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LinkedListCycleTest {
    @Test
    void check() {
        // given
        LinkedListCycle.ListNode l2 = new LinkedListCycle.ListNode(2);
        LinkedListCycle.ListNode l1 = new LinkedListCycle.ListNode(1, l2);

        // when
        var solution = new LinkedListCycle();

        // then
        assertThat(solution.hasCycle(l1)).isEqualTo(false);
    }
}