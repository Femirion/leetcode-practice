package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 2462. Total Cost to Hire K Workers
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 */
public class TotalCostToHireKWorkers {

    /**
     * Runtime 93 ms Beats 18.67% of users with Java
     * Memory 56.40 MB Beats 67.87% of users with Java
     */
    public long totalCost1(int[] costs, int k, int candidates) {
        PriorityQueue<WorkerInfo> firstWorkers = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        PriorityQueue<WorkerInfo> lastWorkers = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));

        int p;
        for (p = 0; p <= candidates - 1; p++) {
            firstWorkers.add(new WorkerInfo(costs[p], p));
        }

        int q;
        for (q = costs.length - 1; costs.length - candidates - 1 < q; q--) {
            if (p < q) {
                lastWorkers.add(new WorkerInfo(costs[q], q));
            } else {
                break;
            }
        }

        long total = 0;
        WorkerInfo wP;
        WorkerInfo wQ = null;
        for (int i = 0; i < k; i++) {
            wP = firstWorkers.peek();
            if (!lastWorkers.isEmpty()) {
                wQ = lastWorkers.peek();
            }

            if (wP == null) {
                total = total + wQ.cost;
                lastWorkers.remove();
                wQ = null;
                wP = null;
                continue;
            }

            if (wQ == null) {
                total = total + wP.cost;
                firstWorkers.remove();
                wQ = null;
                wP = null;
                continue;
            }

            if (wP.cost <= wQ.cost) {
                total = total + wP.cost;
                firstWorkers.remove();
                if (p < q) {
                    firstWorkers.add(new WorkerInfo(costs[p], p));
                    p++;
                }
            } else {
                total = total + wQ.cost;
                lastWorkers.remove();
                if (p < q) {
                    lastWorkers.add(new WorkerInfo(costs[q], q));
                    q--;
                }
            }
            wQ = null;
            wP = null;
        }
        return total;
    }

    /**
     * Runtime 98 ms Beats 14.06% of users with Java
     * Memory 59.35 MB Beats 5.22% of users with Java
     */
    public long totalCost(int[] costs, int k, int candidates) {
        Set<Integer> hiredWorkers = new HashSet<>();
        PriorityQueue<WorkerInfo> firstWorkers = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        PriorityQueue<WorkerInfo> lastWorkers = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));


        LinkedList<WorkerInfo> workers = new LinkedList<>();
        for (int i = 0; i < costs.length; i++) {
            workers.add(new WorkerInfo(costs[i], i));
        }

        int p;
        for (p = 0; p <= candidates - 1; p++) {
            firstWorkers.add(workers.removeFirst());
        }

        int lastPos;

        for (lastPos = costs.length - 1; costs.length - candidates - 1 < lastPos; lastPos--) {
            if (!workers.isEmpty()) {
                lastWorkers.add(workers.removeLast());
            }
        }

        long total = 0;
        WorkerInfo wP;
        WorkerInfo wQ = null;
        for (int i = 0; i < k; i++) {
            wP = firstWorkers.peek();
            if (!lastWorkers.isEmpty()) {
                wQ = lastWorkers.peek();
            }

            if (wP == null) {
                total = total + wQ.cost;
                lastWorkers.remove();
                continue;
            }

            if (wQ == null) {
                total = total + wP.cost;
                firstWorkers.remove();
                continue;
            }

            if (wP.cost <= wQ.cost) {
                total = total + wP.cost;
                firstWorkers.remove();
                if (!workers.isEmpty()) {
                    firstWorkers.add(workers.removeFirst());
                }
            } else {
                total = total + wQ.cost;
                lastWorkers.remove();
                if (!workers.isEmpty()) {
                    lastWorkers.add(workers.removeLast());
                }
            }
            wQ = null;
        }
        return total;
    }



    private static class WorkerInfo {
        int cost;
        int pos;

        public WorkerInfo(int cost, int pos) {
            this.cost = cost;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "WorkerInfo{" +
                    "cost=" + cost +
                    ", pos=" + pos +
                    '}';
        }
    }
}
