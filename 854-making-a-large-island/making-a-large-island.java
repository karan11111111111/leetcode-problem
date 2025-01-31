import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; // Start island IDs from 2 (since grid contains only 0s and 1s)
        Map<Integer, Integer> islandSize = new HashMap<>();
        int maxIsland = 0;

        // Step 1: Label islands and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { 
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        // Step 2: Try flipping each '0' to '1' and calculate potential max island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int potentialSize = 1; // The flipped '1' itself
                    
                    for (int[] d : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            int id = grid[x][y];
                            if (!seenIslands.contains(id)) {
                                seenIslands.add(id);
                                potentialSize += islandSize.get(id);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, potentialSize);
                }
            }
        }

        // If grid is all 1s, return n*n
        return maxIsland == 0 ? n * n : maxIsland;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = id;
        int size = 1;
        for (int[] d : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
            size += dfs(grid, i + d[0], j + d[1], id);
        }
        return size;
    }
}
