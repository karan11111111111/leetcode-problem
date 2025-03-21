// import java.util.*;

// class Solution {
//     public int trapRainWater(int[][] heightMap) {
//         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
//             return 0;
//         }
        
//         int m = heightMap.length, n = heightMap[0].length;
//         boolean[][] visited = new boolean[m][n];
//         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);  // Min-heap by height
        
//         // Add all the boundary cells to the priority queue
//         for (int i = 0; i < m; i++) {
//             minHeap.offer(new int[]{i, 0, heightMap[i][0]});
//             minHeap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
//             visited[i][0] = true;
//             visited[i][n - 1] = true;
//         }
//         for (int j = 0; j < n; j++) {
//             minHeap.offer(new int[]{0, j, heightMap[0][j]});
//             minHeap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
//             visited[0][j] = true;
//             visited[m - 1][j] = true;
//         }
        
//         // Directions for the neighboring cells (up, down, left, right)
//         int[] directions = {-1, 0, 1, 0, -1};
        
//         int waterTrapped = 0;
        
//         // Process cells in the priority queue
//         while (!minHeap.isEmpty()) {
//             int[] cell = minHeap.poll();
//             int x = cell[0], y = cell[1], height = cell[2];
            
//             // Check the four neighbors (up, down, left, right)
//             for (int i = 0; i < 4; i++) {
//                 int newX = x + directions[i], newY = y + directions[i + 1];
                
//                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
//                     visited[newX][newY] = true;
                    
//                     // If the neighbor is lower than the current boundary, water can be trapped
//                     if (heightMap[newX][newY] < height) {
//                         waterTrapped += height - heightMap[newX][newY];
//                     }
                    
//                     // Push the neighbor into the priority queue with the maximum height between the current height and the neighbor
//                     minHeap.offer(new int[]{newX, newY, Math.max(height, heightMap[newX][newY])});
//                 }
//             }
//         }
        
//         return waterTrapped;
//     }
// }

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length; // Grid rows
        int n = heightMap[0].length; // Grid columns
        
        // Step 1: Initialize volumes with terrain heights
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        // Step 2: Iterative spreading to enforce constraints
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            
            // Pass 1: Spread constraints from top-left to bottom-right
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            // Pass 2: Spread constraints from bottom-right to top-left
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // Step 3: Calculate total trapped water
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}