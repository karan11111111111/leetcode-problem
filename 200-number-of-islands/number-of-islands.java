class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Traverse the entire grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell is land, start a DFS to mark the entire island
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // If out of bounds or already water, return
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited (turn it to water)
        grid[i][j] = '0';

        // Recursively visit all adjacent cells (up, down, left, right)
        dfs(grid, i + 1, j, rows, cols); // Down
        dfs(grid, i - 1, j, rows, cols); // Up
        dfs(grid, i, j + 1, rows, cols); // Right
        dfs(grid, i, j - 1, rows, cols); // Left
    }
}
