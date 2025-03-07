class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        
        int[] count = new int[size + 1]; // Frequency array (1-based index)
        int repeated = -1, missing = -1;
        
        // Count occurrences of numbers in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }
        
        // Identify the repeated and missing numbers
        for (int num = 1; num <= size; num++) {
            if (count[num] == 2) repeated = num;
            if (count[num] == 0) missing = num;
        }
        
        return new int[]{repeated, missing};
    }
}
