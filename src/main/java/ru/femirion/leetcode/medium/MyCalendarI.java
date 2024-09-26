package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. My Calendar I
 * https://leetcode.com/problems/my-calendar-i/description/
 */
public class MyCalendarI {

    List<Event> events = new ArrayList<>();

    public MyCalendarI() {
    }

    /**
     * Runtime 58 ms Beats 38.59%
     * Memory 45.28 MB Beats 81.32%
     */
    public boolean book(int start, int end) {
        if (events.isEmpty()) {
            events.add(new Event(start, end));
            return true;
        }

        var tmpEvents = events;

        int left = 0;
        int right = events.size();
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (mid == events.size() || mid < 0) {
                break;
            }
            Event e = events.get(mid);

            if (hasIntersection(start, end, e.start, e.end)) {
                return false;
            }

            if (e.end <= start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        events.add(new Event(start, end));
        events.sort((x, y) -> Integer.compare(x.start, y.start));
        return true;
    }

    private boolean hasIntersection(int newStart, int newEnd, int existedStart, int existedEnd) {
        return !(existedEnd <= newStart || newEnd <= existedStart);
    }

    private static class Event {
        private int start;
        private int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[start=" + start + ", end=" + end + "]";
        }
    }
}
