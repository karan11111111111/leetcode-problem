class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxFish = 0;

        // Iterate over the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0 && !visited[r][c]) {
                    maxFish = Math.max(maxFish, dfs(r, c, grid, visited));
                }
            }
        }

        return maxFish;
    }

    // Helper DFS function moved outside the main method
    private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        // If out of bounds or already visited or no fish, return 0
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int fishCount = grid[r][c];

        // Explore all four directions
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = r + dirs[i];
            int newCol = c + dirs[i + 1];
            fishCount += dfs(newRow, newCol, grid, visited);
        }

        return fishCount;
    }
}
