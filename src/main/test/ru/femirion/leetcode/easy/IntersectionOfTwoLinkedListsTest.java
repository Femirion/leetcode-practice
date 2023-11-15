package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoLinkedListsTest {


    @Test
    void check() {
        // given
        //[4,1,8,4,5]
        IntersectionOfTwoLinkedLists.ListNode n1L1 = new IntersectionOfTwoLinkedLists.ListNode(4);
        IntersectionOfTwoLinkedLists.ListNode n2L1 = new IntersectionOfTwoLinkedLists.ListNode(1);
        IntersectionOfTwoLinkedLists.ListNode n3L1 = new IntersectionOfTwoLinkedLists.ListNode(8);
        IntersectionOfTwoLinkedLists.ListNode n4L1 = new IntersectionOfTwoLinkedLists.ListNode(4);
        IntersectionOfTwoLinkedLists.ListNode n5L1 = new IntersectionOfTwoLinkedLists.ListNode(5);
        n1L1.next = n2L1;
        n2L1.next = n3L1;
        n3L1.next = n4L1;
        n4L1.next = n5L1;
        //[5,6,1,8,4,5]
        IntersectionOfTwoLinkedLists.ListNode n1L2 = new IntersectionOfTwoLinkedLists.ListNode(5);
        IntersectionOfTwoLinkedLists.ListNode n2L2 = new IntersectionOfTwoLinkedLists.ListNode(6);
        n1L2.next = n2L2;
        n2L2.next = n2L1;


        // when
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // then
        assertThat(solution.getIntersectionNode(n1L1, n1L2)).isEqualTo(n2L1);
        assertThat(solution.getIntersectionNode1(n1L1, n1L2)).isEqualTo(n2L1);
    }

}