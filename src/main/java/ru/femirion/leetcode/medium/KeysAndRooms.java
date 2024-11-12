package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms {

    private Set<Integer> closedRooms = new HashSet<>();

    /**
     * Runtime 4 ms Beats 16.44%
     * Memory 44.34 MB Beats 39.19%
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        for (int i = 1; i < rooms.size(); i++) {
            closedRooms.add(i);
        }

        Queue<Integer> keys = new ArrayDeque<>();
        keys.addAll(rooms.get(0));

        while(!keys.isEmpty()) {
            int key = keys.poll();
            if (!closedRooms.contains(key)) {
                continue;
            }
            keys.addAll(rooms.get(key));
            closedRooms.remove(key);
        }


        return closedRooms.size() == 0;
    }
}
