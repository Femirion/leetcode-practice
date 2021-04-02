package ru.femirion.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        // given
        AddTwoNumbers.ListNode l13 = new AddTwoNumbers.ListNode(3, null);
        AddTwoNumbers.ListNode l12 = new AddTwoNumbers.ListNode(4, l13);
        AddTwoNumbers.ListNode l11 = new AddTwoNumbers.ListNode(2, l12);

        AddTwoNumbers.ListNode l23 = new AddTwoNumbers.ListNode(4, null);
        AddTwoNumbers.ListNode l22 = new AddTwoNumbers.ListNode(6, l23);
        AddTwoNumbers.ListNode l21 = new AddTwoNumbers.ListNode(5, l22);

        // when
        var solution = new AddTwoNumbers();
        var result = solution.addTwoNumbers(l11, l21);

        // then
        assertThat(result.val).isEqualTo(7);
        assertThat(result.next.val).isEqualTo(0);
        assertThat(result.next.next.val).isEqualTo(8);
    }
}