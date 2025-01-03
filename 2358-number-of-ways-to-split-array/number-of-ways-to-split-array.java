class Solution {
    public int waysToSplitArray(int[] nums){
        int n = nums.length;

        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        int validSplits = 0;

        // Iterate through the array to check valid splits
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i]; // Add the current element to leftSum
            long rightSum = totalSum - leftSum; // Calculate the right-side sum

            // Check if the current split is valid
            if (leftSum >= rightSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
