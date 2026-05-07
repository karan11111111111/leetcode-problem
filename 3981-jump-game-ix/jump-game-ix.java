class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Step 1: Precompute prefix maximums
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        // Step 2: Precompute suffix minimums
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        // Step 3: Identify connected components (chunks)
        int start = 0;
        for (int i = 0; i < n; i++) {
            // Check if a cut happens at index i
            // A cut exists if all values to the left (0...i) are <= all values to the right (i+1...n-1)
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {
                // We found a chunk from 'start' to 'i'
                int currentChunkMax = prefixMax[i];
                if (start > 0) {
                    // The max of the current chunk is just the max in this range
                    currentChunkMax = 0;
                    for (int j = start; j <= i; j++) {
                        currentChunkMax = Math.max(currentChunkMax, nums[j]);
                    }
                }
                
                // Fill the result for this component
                for (int j = start; j <= i; j++) {
                    ans[j] = currentChunkMax;
                }
                start = i + 1;
            }
        }
        
        return ans;
    }
}