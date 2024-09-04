package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 874. Walking Robot Simulation
 * https://leetcode.com/problems/walking-robot-simulation/description/
 */
public class WalkingRobotSimulation {

    /**
     * Runtime 41 ms Beats 20.96%
     * Memory 56.32 MB Beats 6.55%
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int curX = 0;
        int curY = 0;
        int furthestPoint = 0;

        Map<Integer, Set<Integer>> obstacleX = new HashMap<>();
        Map<Integer, Set<Integer>> obstacleY = new HashMap<>();
        for (int[] obs : obstacles) {
            Set<Integer> obstacleYs = obstacleX.getOrDefault(obs[0], new HashSet<>());
            obstacleYs.add(obs[1]);
            obstacleX.put(obs[0], obstacleYs);

            Set<Integer> obstacleXs = obstacleY.getOrDefault(obs[1], new HashSet<>());
            obstacleXs.add(obs[0]);
            obstacleY.put(obs[1], obstacleXs);
        }

        // norht = 0, east = 1, south = 2, west = 3
        int direction = 0;
        for (int com : commands) {
            if (com == -1) {
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
                continue;
            }
            if (com == -2) {
                direction--;
                if (direction == -1) {
                    direction = 3;
                }
                continue;
            }
            for (int i = 0; i < com; i++) {
                Set<Integer> obstacleXs = obstacleY.getOrDefault(curY + getYDirection(direction), new HashSet<>());
                Set<Integer> obstacleYs = obstacleX.getOrDefault(curX + getXDirection(direction), new HashSet<>());
                if (!obstacleXs.contains(curX + getXDirection(direction)) && !obstacleYs.contains(curY + getYDirection(direction))) {
                    curX = curX + getXDirection(direction);
                    curY = curY + getYDirection(direction);
                }
            }
            furthestPoint = Math.max(furthestPoint, curX * curX + curY * curY);
        }

        return furthestPoint;
    }

    private int getXDirection(int direction) {
        if (direction == 0 || direction == 2) {
            return 0;
        } else if (direction == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    private int getYDirection(int direction) {
        if (direction == 1 || direction == 3) {
            return 0;
        } else if (direction == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
