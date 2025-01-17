import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if intervals are empty or have only one interval
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Iterate through the intervals
        for (int[] interval : intervals) {
            // If the list is empty or there's no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlapping intervals: merge by updating the end time
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Step 4: Convert the list to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
