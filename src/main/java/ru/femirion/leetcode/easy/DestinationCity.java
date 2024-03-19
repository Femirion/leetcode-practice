package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1436. Destination City
 * https://leetcode.com/problems/destination-city/description/
 */
public class DestinationCity {

    /**
     * Runtime 2 ms Beats 99.51% of users with Java
     * Memory 43.23 MB Beats 46.59% of users with Java
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>();

        for (List<String> path : paths) {
            pathMap.put(path.get(0), path.get(1));
        }

        String cityA;
        String cityB = paths.get(0).get(1);

        while (pathMap.get(cityB) != null) {
            cityA = pathMap.get(cityB);
            cityB = pathMap.get(cityA);
            if (cityB == null) {
                return cityA;
            }
        }

        return cityB;
    }
}
