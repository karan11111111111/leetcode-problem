class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num); // Maximum subarray sum
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num); // Minimum subarray sum
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(maxSum, Math.abs(minSum)); // Max absolute sum
    }
}
