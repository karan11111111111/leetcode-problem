import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        // Flatten grid into a 1D list
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }

        // Sort the numbers to find the median
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int operations = 0;

        // Check feasibility and calculate operations
        for (int num : nums) {
            if ((num - median) % x != 0) return -1; // Not possible
            operations += Math.abs(num - median) / x; // Count steps
        }

        return operations;
    }
}
