import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColors = new HashMap<>();  // Maps each ball to its color
        Map<Integer, Integer> colorCount = new HashMap<>();  // Tracks occurrences of each color
        Set<Integer> uniqueColors = new HashSet<>();  // Tracks distinct colors
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    uniqueColors.remove(oldColor);
                }
            }

            ballColors.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            uniqueColors.add(color);

            result[i] = uniqueColors.size();
        }

        return result;
    }
}
