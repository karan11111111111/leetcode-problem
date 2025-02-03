class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;  // A single element is a valid subarray

        int inc = 1, dec = 1, maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) { // Increasing
                inc++;
                dec = 1; // Reset decreasing count
            } else if (nums[i] < nums[i - 1]) { // Decreasing
                dec++;
                inc = 1; // Reset increasing count
            } else { 
                inc = 1;
                dec = 1; 
            }
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }
        return maxLen;
    }
}
