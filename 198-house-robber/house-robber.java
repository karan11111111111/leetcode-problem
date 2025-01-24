public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  // No houses, no money
        }
        
        if (nums.length == 1) {
            return nums[0];  // Only one house, rob it
        }
        
        // Initialize variables to store the previous two results
        int prev2 = 0;  // dp[i-2]
        int prev1 = nums[0];  // dp[i-1]
        
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);  // Max of robbing or not robbing current house
            prev2 = prev1;  // Update prev2 to the previous prev1
            prev1 = current;  // Update prev1 to the current result
        }
        
        return prev1;  // The final result is in prev1
    }
}
