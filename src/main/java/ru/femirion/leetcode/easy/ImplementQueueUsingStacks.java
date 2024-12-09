package ru.femirion.leetcode.easy;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 =  new Stack<>();

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.22 MB Beats 60.02%
     */
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        moveAllFromStack1ToStack2(stack1, stack2);
        int value = stack2.pop();
        moveAllFromStack1ToStack2(stack2, stack1);
        return value;
    }

    public int peek() {
        moveAllFromStack1ToStack2(stack1, stack2);
        int value = stack2.peek();
        moveAllFromStack1ToStack2(stack2, stack1);
        return value;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    private void moveAllFromStack1ToStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
