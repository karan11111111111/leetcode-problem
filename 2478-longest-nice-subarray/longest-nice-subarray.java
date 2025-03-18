class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitMask = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // While there's an overlap, shrink from the left
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left];  // Remove nums[left] from bitMask
                left++;
            }

            // Add nums[right] to the bitMask
            bitMask |= nums[right];

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
