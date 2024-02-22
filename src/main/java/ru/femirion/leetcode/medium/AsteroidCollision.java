package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/description/
 */
public class AsteroidCollision {

    /**
     * Runtime 7 ms Beats 49.86% of users with Java
     * Memory 45.16 MB Beats 74.17% of users with Java
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int current;
        int top;
        int tmp;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            current = asteroids[i];

            if (current > 0) {
                stack.push(current);
            }

            if (current < 0) {
                if (!stack.isEmpty()) {
                    while(true) {
                        top = stack.peek();
                        tmp = current + top;
                        if (tmp == 0) {
                            stack.pop();
                            break;
                        }
                        if (tmp > 0) {
                            break;
                        }
                        stack.pop();
                        if (stack.isEmpty()) {
                            result.add(current);
                            break;
                        }
                    }
                } else {
                    result.add(current);
                }
            }
        }

        result.addAll(stack);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
