class Solution {
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     boolean[] dp = new boolean[n];
    //     dp[0] = true; // You can always start at the first index

    //     for (int i = 0; i < n; i++) {
    //         if (dp[i]) { // If you can reach index i
    //             for (int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
    //                 dp[j] = true; // You can reach index j from index i
    //             }
    //         }
    //     }

    //     return dp[n - 1]; // Check if you can reach the last index
    // }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0; // The farthest index that can be reached

        for (int i = 0; i < n; i++) {
            // If we can't reach this index, return false
            if (i > farthest) {
                return false;
            }
            // Update the farthest index we can reach from this position
            farthest = Math.max(farthest, i + nums[i]);

            // If we can reach or exceed the last index, return true
            if (farthest >= n - 1) {
                return true;
            }
        }
        return false; // We reached the end of the loop without being able to jump to the last index
    }
}