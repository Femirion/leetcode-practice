package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MergeSimilarItemsTest {
    @Test
    void check() {
        // when
        var solution = new MergeSimilarItems();

        // then
        assertThat(solution.mergeSimilarItems2(
                new int[][]{new int[] {1, 1}, new int[] {4, 5}, new int[] {3, 8}},
                new int[][]{new int[] {3, 1}, new int[] {1, 5}}
        )).isEqualTo(expected());
    }

    private List<List<Integer>> expected() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(6);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(9);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(5);
        result.add(list1);
        result.add(list2);
        result.add(list3);
        return result;
    }
}