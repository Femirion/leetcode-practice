package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. Group the People Given the Group Size They Belong To
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    /**
     * Runtime 7 ms Beats 64.55%
     * Memory 45.32 MB Beats 42.55%
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int curSize = groupSizes[i];
            List<Integer> list = map.getOrDefault(curSize, new ArrayList<>(curSize));
            list.add(i);
            if (list.size() == curSize) {
                result.add(new ArrayList<>(list));
                list = new ArrayList<>();
            }
            map.put(curSize, list);
        }

        return result;
    }
}
