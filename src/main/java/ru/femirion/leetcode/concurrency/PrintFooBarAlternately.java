package ru.femirion.leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1115. Print FooBar Alternately
 * https://leetcode.com/problems/print-foobar-alternately/description/
 */
public class PrintFooBarAlternately {

    private int n;
    private int cur = 1;
    private final Object monitor = new Object();

    Semaphore m = new Semaphore(1);

    /**
     * Runtime 24 ms Beats 33.71%
     * Memory 43.70 MB Beats 56.89%
     */
    public void foo(Runnable printFoo) throws InterruptedException {

        m.acquire();

        for (int i = 0; i < n; i++) {
            synchronized(monitor) {
                while (cur % 2 == 0) {
                    monitor.wait();
                }
                printFoo.run();
                cur++;
                monitor.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(monitor) {
                while (cur % 2 != 0) {
                    monitor.wait();
                }
                printBar.run();
                cur++;
                monitor.notifyAll();
            }
        }
    }
}
