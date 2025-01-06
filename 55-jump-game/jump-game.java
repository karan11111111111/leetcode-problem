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

        int far =0;

        for(int i=0; i<n; i++){

            if(i>far){
                return false;
            }

            far = Math.max(far, i+nums[i]);

            if(far>= n-1){
                return true;
            }

        }

        return false;
    }
}