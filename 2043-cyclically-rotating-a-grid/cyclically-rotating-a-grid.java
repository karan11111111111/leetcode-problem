class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            // 1. Extract elements of the current layer
            List<Integer> elements = new ArrayList<>();
            
            // Top row
            for (int j = layer; j < n - layer - 1; j++) elements.add(grid[layer][j]);
            // Right column
            for (int i = layer; i < m - layer - 1; i++) elements.add(grid[i][n - layer - 1]);
            // Bottom row
            for (int j = n - layer - 1; j > layer; j--) elements.add(grid[m - layer - 1][j]);
            // Left column
            for (int i = m - layer - 1; i > layer; i--) elements.add(grid[i][layer]);

            // 2. Calculate effective rotation
            int L = elements.size();
            int shift = k % L;

            // 3. Re-insert elements back into the grid at shifted positions
            int index = shift; // Start at the offset to achieve rotation
            
            for (int j = layer; j < n - layer - 1; j++) grid[layer][j] = elements.get(index++ % L);
            for (int i = layer; i < m - layer - 1; i++) grid[i][n - layer - 1] = elements.get(index++ % L);
            for (int j = n - layer - 1; j > layer; j--) grid[m - layer - 1][j] = elements.get(index++ % L);
            for (int i = m - layer - 1; i > layer; i--) grid[i][layer] = elements.get(index++ % L);
        }

        return grid;
    }
}