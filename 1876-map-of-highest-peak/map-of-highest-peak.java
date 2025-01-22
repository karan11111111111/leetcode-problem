import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        
        // Result grid to store heights
        int[][] heights = new int[rows][cols];
        
        // Directions for moving in 4 directions (up, down, left, right)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Initialize queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the heights array and enqueue water cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0; // Water cells have height 0
                    queue.offer(new int[]{i, j}); // Add water cells to the queue
                } else {
                    heights[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }
        
        // Perform BFS to calculate heights
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            // Check all 4 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // If the new cell is within bounds and unvisited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1; // Update height
                    queue.offer(new int[]{newX, newY}); // Add the cell to the queue
                }
            }
        }
        
        return heights;
    }
}
