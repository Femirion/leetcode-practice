package ru.femirion.leetcode.medium;

import java.util.ArrayDeque;

/**
 * 649. Dota2 Senate
 * https://leetcode.com/problems/dota2-senate/description/
 */
public class Dota2Senate {

    /**
     * Runtime 10 ms Beats 82.58% of users with Java
     * Memory 44.38 MB Beats 84.71% of users with Java
     */
    public String predictPartyVictory1(String senate) {
        ArrayDeque<Integer> rQueue = new ArrayDeque<>();
        ArrayDeque<Integer> dQueue = new ArrayDeque<>();

        char cur;
        int offset = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            cur = senate.charAt(i);
            if (cur == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        int r;
        int d;
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            r = rQueue.poll();
            d = dQueue.poll();
            if (r > d) {
                dQueue.add(d + offset);
            } else {
                rQueue.add(r + offset);
            }
        }

        return rQueue.isEmpty() ? "Radiant" : "Dire";
    }

    /**
     * Runtime 129 ms Beats 5.68% of users with Java
     * Memory 45.14 MB Beats 54.31% of users with Java
     */
    public String predictPartyVictory(String senate) {
        ArrayDeque<Character> votedQueue = new ArrayDeque<>();
        ArrayDeque<Character> unvotedQueue = new ArrayDeque<>();

        char cur;
        char unvotedSenator;
        char votedSenator;

        while (true) {
            for (int i = 0; i < senate.length(); i++) {
                cur = senate.charAt(i);
                if (!unvotedQueue.isEmpty()) {
                    unvotedSenator = unvotedQueue.peek();
                    if (unvotedSenator == cur) {
                        unvotedQueue.add(cur);
                    } else {
                        unvotedQueue.removeFirst();
                        votedQueue.add(unvotedSenator);
                    }
                } else {
                    unvotedQueue.add(cur);
                }
            }

            boolean banVotedSenator = false;
            while(!unvotedQueue.isEmpty()) {
                unvotedSenator = unvotedQueue.peek();

                ArrayDeque<Character> tmp = new ArrayDeque<>();
                while (!votedQueue.isEmpty()) {
                    votedSenator = votedQueue.poll();
                    if (votedSenator != unvotedSenator && !banVotedSenator) {
                        banVotedSenator = true;
                    } else {
                        tmp.add(votedSenator);
                    }
                }

                if (banVotedSenator) {
                    tmp.add(unvotedSenator);
                    votedQueue = tmp;
                    unvotedQueue.remove();
                } else {
                    break;
                }
                banVotedSenator = false;
            }

            if (!unvotedQueue.isEmpty()) {
                return 'R' == unvotedQueue.peek() ? "Radiant" : "Dire";
            }

            StringBuilder sb = new StringBuilder();
            for (char c : votedQueue) {
                sb.append(c);
            }
            senate = sb.toString();
            votedQueue = new ArrayDeque<>();
            unvotedQueue= new ArrayDeque<>();
        }
    }
}