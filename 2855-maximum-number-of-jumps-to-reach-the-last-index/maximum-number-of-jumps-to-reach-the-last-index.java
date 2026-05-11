import java.util.Arrays;

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        // dp[i] stores the maximum jumps to reach index i
        int[] dp = new int[n];
        
        // Initialize with -1 to indicate the index hasn't been reached yet
        Arrays.fill(dp, -1);
        
        // Starting point
        dp[0] = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if index j is reachable and if the jump condition is met
                if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    // Update dp[i] with the maximum jumps found so far
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}