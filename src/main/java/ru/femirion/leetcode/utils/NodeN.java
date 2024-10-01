package ru.femirion.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class NodeN {

    public int val;
    public List<NodeN> children;


    public NodeN() {
        children = new ArrayList<NodeN>();
    }

    public NodeN(int _val) {
        val = _val;
        children = new ArrayList<NodeN>();
    }

    public NodeN(int _val, ArrayList<NodeN> _children) {
        val = _val;
        children = _children;
    }
}
