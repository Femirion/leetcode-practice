package ru.femirion.leetcode.concurrency;

/**
 * 1114. Print in Order
 * https://leetcode.com/problems/print-in-order/description/
 */
public class PrintInOrder {

    private volatile byte currThread = 1;

    /**
     * Runtime 13 ms Beats 49.23%
     * Memory 41.83 MB Beats 82.14%
     */
    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (currThread != 1) {
            wait();
        }
        currThread = 2;
        printFirst.run();
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (currThread != 2) {
            wait();
        }
        currThread = 3;
        printSecond.run();
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (currThread != 3) {
            wait();
        }
        currThread = 1;
        printThird.run();
        notifyAll();
    }
}
