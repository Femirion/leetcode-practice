package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. Product of the Last K Numbers
 * https://leetcode.com/problems/product-of-the-last-k-numbers/description/
 */
public class ProductOfTheLastKNumbers {

    List<Integer> prods = new ArrayList<>();
    int prod = 1;

    /**
     * Runtime 15 ms Beats 91.34%
     * Memory 68.88 MB Beats 65.04%
     */
    public void add(int num) {
        if (num == 0) {
            prods = new ArrayList<>();
            prod = 1;
            return;
        } else {
            prod = prod * num;
            prods.add(prod);
        }
    }

    public int getProduct(int k) {
        if (prods.size() < k) {
            return 0;
        }
        int last = prods.get(prods.size() - 1);
        if (prods.size() == k) {
            return last;
        }
        return last / prods.get(prods.size() - 1 - k);
    }
}
