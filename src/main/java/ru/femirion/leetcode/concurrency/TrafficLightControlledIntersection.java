package ru.femirion.leetcode.concurrency;

/**
 * 1279. Traffic Light Controlled Intersection
 * https://leetcode.com/problems/traffic-light-controlled-intersection/description/
 */
public class TrafficLightControlledIntersection {

    private volatile boolean isGreen = true;

    /**
     * Runtime 10 ms Beats 100.00%
     * Memory 44.04 MB Beats 9.50%
     */
    public synchronized void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        if (direction == 1 || direction == 2) {
            if (!isGreen) {
                turnGreen.run();
                isGreen = true;
            }
            crossCar.run();
        } else {
            if (isGreen) {
                turnGreen.run();
                isGreen = false;
            }
            crossCar.run();
        }
    }
}
