package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2418. Sort the People
 * https://leetcode.com/problems/sort-the-people/description/
 */
public class SortThePeople {

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
