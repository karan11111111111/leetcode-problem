class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        // Difference array to track change in moves for each possible sum
        // Range of sums is [2, 2 * limit], so size 2 * limit + 2 is safe
        int[] diff = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            // Default: 2 moves for every sum
            int minVal = Math.min(a, b);
            int maxVal = Math.max(a, b);
            
            // Range for 2 moves: [2, 2 * limit]
            // We start by assuming 2 moves for all sums
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            
            // Range for 1 move: [minVal + 1, maxVal + limit]
            // In this range, we "save" one move compared to the default of 2
            diff[minVal + 1] -= 1;
            diff[maxVal + limit + 1] += 1;
            
            // Range for 0 moves: exactly a + b
            // We "save" one more move at this specific sum
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }
        
        int minMoves = n; // Max possible moves is n
        int currentMoves = 0;
        
        // Sweep through the difference array to find the minimum moves
        for (int s = 2; s <= 2 * limit; s++) {
            currentMoves += diff[s];
            minMoves = Math.min(minMoves, currentMoves);
        }
        
        return minMoves;
    }
}