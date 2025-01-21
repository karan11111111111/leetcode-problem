class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Calculate prefix sums for both rows
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];

        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];

        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        // Initialize the minimum possible score for Player 1
        long minScore = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Calculate the score for Player 2 if Player 1 moves down at column i
            long topSum = i < n - 1 ? topPrefix[n - 1] - topPrefix[i] : 0;
            long bottomSum = i > 0 ? bottomPrefix[i - 1] : 0;

            // Player 2's optimal move is the max of these two sums
            long player2Score = Math.max(topSum, bottomSum);

            // Player 1 wants to minimize this score
            minScore = Math.min(minScore, player2Score);
        }

        return minScore;
    }
}
