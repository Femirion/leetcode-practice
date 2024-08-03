package ru.femirion.leetcode.easy;

import java.util.*;

/**
 * 2418. Sort the People
 * https://leetcode.com/problems/sort-the-people/description/
 */
public class SortThePeople {

    /**
     * Runtime 7 ms Beats 91.55%
     * Memory 44.99 MB Beats 96.38%
     */
    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] result = new String[heights.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }
        return result;
    }

    /**
     * Runtime 10 ms Beats 28.64%
     * Memory 45.31 MB Beats 41.40%
     */
    public String[] sortPeople(String[] names, int[] heights) {
        String[] result = new String[names.length];

        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            persons.add(new Person(names[i], heights[i]));
        }

        Collections.sort(persons, (a, b) -> Integer.compare(b.height, a.height));

        for (int i = 0; i < names.length; i++) {
            result[i] = persons.get((Integer) i).name;
        }

        return result;
    }

    private static class Person {
        private String name;
        private int height;

        public Person (String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
