package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MiddleOfTheLinkedListTest {
    @Test
    void check() {
        // when
        var solution = new MiddleOfTheLinkedList();
        //1,2,3,4,5
        MiddleOfTheLinkedList.ListNode head = new MiddleOfTheLinkedList.ListNode(1);
        MiddleOfTheLinkedList.ListNode e1 = new MiddleOfTheLinkedList.ListNode(2);
        MiddleOfTheLinkedList.ListNode e2 = new MiddleOfTheLinkedList.ListNode(3);
        MiddleOfTheLinkedList.ListNode e3 = new MiddleOfTheLinkedList.ListNode(4);
        MiddleOfTheLinkedList.ListNode e4 = new MiddleOfTheLinkedList.ListNode(5);
        head.next = e1;
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        // then
        assertThat(solution.middleNode(head).toString()).isEqualTo("[3, 4, 5]");
    }
}