package ru.femirion.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    private Integer integer;
    private List<NestedInteger> nestedIntegers = new ArrayList<>();

    public NestedInteger() {
    }

    public NestedInteger(int value) {
        this.integer = value;
    }

    public boolean isInteger() {
        return this.integer != null;
    }

    public Integer getInteger() {
        return this.integer;
    }

    public void setInteger(int value) {
        this.integer = value;
    }

    public void add(NestedInteger ni) {
        this.nestedIntegers.add(ni);
    }

    public List<NestedInteger> getList() {
        return nestedIntegers;
    }
}
